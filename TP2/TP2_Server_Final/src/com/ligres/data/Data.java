package com.ligres.data;

public class Data {
	private String name;
	private String email;
	private String number;
	private String password;

	public Data(String name, String email, String number, String password) {
		this.name = name;
		this.email = email;
		this.number = number;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
