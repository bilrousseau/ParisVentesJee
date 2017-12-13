package com.parisventes.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.parisventes.beans.Person;


@WebServlet("/lostpassword")
public class LostPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LostPassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/lostpassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		Person user = Person.getByEmail(email);
		if (user != null) {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			Session session = Session.getInstance(props);
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("postmaster@parisventes.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("ParisVentes - Mot de passe oublié");
				message.setText("Bonjour, \n Vous avez cliqué sur le bouton \"Mot de passe oublié\".\n Voici votre mot de passe :\n\n"+user.getPassword());
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("error", "Adresse e-mail inconnue.");
		}
		
		doGet(request, response);
	}

}
