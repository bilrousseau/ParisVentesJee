package com.parisventes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PUBLIC_ACCESS     = "/index.jsp";
    public static final String RESTRICTED_ACCESS  = "/restricted/index.jsp";
    public static final String ATT_SESSION_USER = "userSession";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute(ATT_SESSION_USER) == null) {
			response.sendRedirect(request.getContextPath() + PUBLIC_ACCESS);
		} else {
			this.getServletContext().getRequestDispatcher(RESTRICTED_ACCESS).forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
