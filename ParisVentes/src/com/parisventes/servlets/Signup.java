package com.parisventes.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.beans.DB;
import com.parisventes.beans.Person;

@WebServlet("/Signup")
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
		
		if (this.validate(params)) {
			Person newUser = new Person(params.get("firstname")[0], params.get("lastname")[0], params.get("email")[0], params.get("phone")[0], params.get("password")[0]);
			newUser.setId(DB.getLinesNb(DB.PERSON_FILENAME) + 1);
			newUser.register();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}
	
	private Boolean validate(Map<String, String[]> params) {
		return true;
	}

}
