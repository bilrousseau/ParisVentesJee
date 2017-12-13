package com.parisventes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parisventes.beans.Person;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
		Person user = Person.getByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				session.setAttribute("userName", username);
				session.setAttribute("userEmail", email);
				session.setAttribute("userPassword", password);
				session.setAttribute("isUserLogged", true);
				this.clearAllErrors(session);
			} else {
				request.setAttribute("errorPwdClass", "error");
				request.setAttribute("errorPwd", "Mot de passe invalide pour cet utilisateur.");
			}
		} else {
			request.setAttribute("errorEmailClass", "error");
			request.setAttribute("errorEmail", "Pas d'utilisateur existant pour cet e-mail.");
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
	
	private void clearAllErrors(HttpSession session) {
		session.setAttribute("errorPwdClass", null);
		session.setAttribute("errorPwd", null);
		session.setAttribute("errorEmailClass", null);
		session.setAttribute("errorEmail", null);
	}

}
