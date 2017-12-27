package com.parisventes.searchuser.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.register.model.Person;

public class SearchUserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private Person personBean;
	private Map<String, Object> session;
	
	public String execute() {
		this.setPersonBean(Person.findByEmail(this.getPersonBean().getEmail()));
		
		return SUCCESS;
	}
	
	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
}
