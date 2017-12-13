package com.parisventes.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.beans.DB;
import com.parisventes.beans.Person;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Signup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();
		
		Map<String, String> signupErrors = this.getErrors(params);
		if (signupErrors.isEmpty()) {
			Person newUser = new Person(params.get("firstname")[0], params.get("lastname")[0], params.get("email")[0], params.get("phone")[0], params.get("password")[0]);
			newUser.setId(DB.getLinesNb(DB.PERSON_FILENAME) + 1);
			newUser.register();
		}
		request.setAttribute("signupErrors", signupErrors);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}
	
	private Map<String, String> getErrors(Map<String, String[]> params) {
		HashMap<String, String> errorMap = new HashMap<String, String>();
		if (params.get("firstname")[0].length() < 2) {
			errorMap.put("errorFirstname", "Veuillez renseigner le prénom (min. 3 lettres)");
		} 
		else if (!params.get("firstname")[0].matches("[a-zA-Z]+\\.?")) {
			errorMap.put("errorFirstname", "Le prénom ne peut contenir que des lettres");
		} 
		else if (params.get("lastname")[0].length() < 2) {
			errorMap.put("errorLastname", "Veuillez renseigner le nom (min. 3 lettres)");
		} 
		else if (!params.get("lastname")[0].matches("[a-zA-Z]+\\.?")) {
			errorMap.put("errorLastname", "Le nom ne peut contenir que des lettres");
		} 
		else if (params.get("email")[0].length() < 2) {
			errorMap.put("errorEmail", "Veuillez renseigner l'e-mail");
		}
		else if (!(params.get("email")[0].matches(DB.EMAIL_REGEXP))) {
			errorMap.put("errorEmail", "Adresse e-mail invalide");
		} 
		else if (params.get("phone")[0].length() < 2) {
			errorMap.put("errorPhone", "Veuillez renseigner le numéro de téléphone");
		} 
		else if (params.get("password")[0].length() < 2 || params.get("passwordRepeat")[0].length() < 2) {
			errorMap.put("errorPassword", "Veuillez renseigner le mot de passe");
		} 
		else if (!params.get("password")[0].equals(params.get("passwordRepeat")[0])) {
			errorMap.put("errorPassword", "Les deux mots de passe ne correspondent pas");
		}
		//TODO: optimiser cette gestion d'erreurs pour le phone
		
		return errorMap;
	}

}
