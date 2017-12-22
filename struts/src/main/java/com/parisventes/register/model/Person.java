package com.parisventes.register.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.parisventes.beans.DB;

public class Person {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	
	public Person() {
		super();
	}
	
	
	public Person(String firstname, String lastname, String email, String phone, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}


	public Person(Integer id, String firstname, String lastname, String email, String phone, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	
	public static ArrayList<Person> getAll() {
		
		try {
			ArrayList<Person> personList = new ArrayList<Person>();
			ResultSet res = DB.executeSelect("SELECT * FROM users");
			
			while (res.next()) {
				personList.add(getPerson(res));
			}
			res.close();
			return personList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static Person findByEmail(String email) {
		
		try {
			ResultSet res = DB.executeSelect("SELECT * FROM users WHERE usr_email = "+ DB.parseToSql(email)+" ;");
			if (res.next()) {
				return getPerson(res);
			}
			res.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
	
	public Integer register() {
		Integer linesInserted = 0;
		String query = "INSERT INTO users (usr_firstname, usr_lastname, usr_email, usr_phone, usr_password) VALUES (";
		query += DB.parseToSql(this.getFirstname()) + "," + DB.parseToSql(this.getLastname()) + "," + DB.parseToSql(this.getEmail()) + "," + DB.parseToSql(this.getPhone()) + "," + DB.parseToSql(this.getPassword()) + ");";
		
		try {
			linesInserted = DB.executeInsert(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return linesInserted;

	}
	
	private static Person getPerson(ResultSet res) throws SQLException {
		return new Person(
			res.getString("usr_firstname"), res.getString("usr_lastname"), res.getString("usr_email"), res.getString("usr_phone"), res.getString("usr_password")
		);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return this.getFirstname()+";"+this.getLastname()+";"+this.getEmail()+";"+this.getPhone()+";"+this.getPassword();
	}
}
