package com.parisventes.login.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.register.model.Person;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Person personBean;
	private Map<String, Object> session;
	
	public String execute() {
	
		this.session.put("user", this.personBean);
		this.session.put("isUserLogged", true);
		return SUCCESS;
	}
	
	public String logOut() {
		this.session.clear();
		return SUCCESS;
	}

	public void validate() {
		Person userFound = Person.findByEmail(this.personBean.getEmail());
		
		if (userFound == null) {
			addFieldError("personBean.email", "Pas d'utilisateur pour cet e-mail");
		} else if (!userFound.getPassword().equals(this.personBean.getPassword())) {
			addFieldError("personBean.password", "Mot de passe invalide");
		}
	}
	
	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
