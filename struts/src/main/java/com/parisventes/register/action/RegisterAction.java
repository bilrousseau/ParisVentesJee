package com.parisventes.register.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parisventes.beans.DB;
import com.parisventes.register.model.Person;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Person personBean;
	private String passwordRepeat;
	
	public String execute() {
		this.getPersonBean().register();
		return SUCCESS;
	}

	public void validate() {
		if (this.getPersonBean().getFirstname().length() < 2) {
			addFieldError("personBean.firstname", "Veuillez renseigner le prénom (min. 3 lettres)");
		} 
		else if (!this.getPersonBean().getFirstname().matches("[a-zA-Z]+\\.?")) {
			addFieldError("personBean.firstname", "Le prénom ne peut contenir que des lettres");
		} 
		else if (this.getPersonBean().getLastname().length() < 2) {
			addFieldError("personBean.lastname", "Veuillez renseigner le nom (min. 3 lettres)");
		} 
		else if (!this.getPersonBean().getLastname().matches("[a-zA-Z]+\\.?")) {
			addFieldError("personBean.lastname", "Le nom ne peut contenir que des lettres");
		} 
		else if (this.getPersonBean().getEmail().length() < 2) {
			addFieldError("personBean.email", "Veuillez renseigner l'e-mail");
		}
		else if (!(this.getPersonBean().getEmail().matches(DB.EMAIL_REGEXP))) {
			addFieldError("personBean.email", "Adresse e-mail invalide");
		} 
		else if (this.getPersonBean().getPhone().length() < 2) {
			addFieldError("personBean.phone", "Veuillez renseigner le numéro de téléphone");
		} 
		else if (this.getPersonBean().getPassword().length() < 4) {
			addFieldError("personBean.password", "Veuillez renseigner le mot de passe (4 lettres min.)");
		} 
		else if (!this.getPersonBean().getPassword().equals(this.getPasswordRepeat())) {
			addFieldError("passwordRepeat", "Les deux mots de passe ne correspondent pas");
		}
	}
	
	public Person getPersonBean() {
		return this.personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	
	
}
