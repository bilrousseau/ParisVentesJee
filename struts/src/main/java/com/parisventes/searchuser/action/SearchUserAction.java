package com.parisventes.searchuser.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.register.model.Person;

public class SearchUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Person personBean;

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
	
	
	
}
