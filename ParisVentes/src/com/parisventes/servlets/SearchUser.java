package com.parisventes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.beans.Person;

public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("requestSent", false);
		this.getServletContext().getRequestDispatcher("/WEB-INF/searchuser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userEmail = request.getParameter("userEmail");
		Person userFound = Person.getByEmail(userEmail);
		request.setAttribute("userFound", userFound);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("requestSent", true);
		this.getServletContext().getRequestDispatcher("/WEB-INF/searchuser.jsp").forward(request, response);
		
	}

}
