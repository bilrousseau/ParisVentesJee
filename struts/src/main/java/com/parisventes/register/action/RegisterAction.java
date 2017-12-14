package com.parisventes.register.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.beans.DB;
import com.parisventes.register.model.Person;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Person personBean;
	
	public String execute() {
		this.personBean.setId(DB.getLinesNb(DB.PERSON_FILENAME) + 1);
		this.personBean.register();
		return SUCCESS;
	}

	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}
	
	
}
