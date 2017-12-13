package com.parisventes.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public Person(Integer id, String firstname, String lastname, String email, String phone, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	
	public static ArrayList<Person> getAll() {
		ArrayList<Person> personList = new ArrayList<Person>();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(DB.PERSON_FILENAME));
			
			while (br.ready()) {
				String[] lineArr = br.readLine().split(";");
	        	personList.add(
	        		new Person(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], lineArr[3], lineArr[4], lineArr[5])
	        	);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return personList;
	}
	
	public static Person getByEmail(String email) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(DB.PERSON_FILENAME));
			
			while (br.ready()) {
				String[] lineArr = br.readLine().split(";");
				
				if (lineArr[3].equals(email)) {
					br.close();
					return new Person(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], lineArr[3], lineArr[4], lineArr[5]); 
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());		
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return null;
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
	
	
}
