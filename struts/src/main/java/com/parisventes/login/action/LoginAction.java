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
		Person userFound = this.personBean.getByEmail(this.personBean.getEmail());
		if (userFound != null) {
			if (userFound.getPassword().equals(this.personBean.getPassword())) {
				this.session.put("user", userFound);
				this.session.put("isUserLogged", true);
				return SUCCESS;
			}
		} else {
			return INPUT;
		}
		return INPUT;
		
	}

	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public Map<String, Object> getSessionMap() {
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
