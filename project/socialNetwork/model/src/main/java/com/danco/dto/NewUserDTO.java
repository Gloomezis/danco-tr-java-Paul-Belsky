package com.danco.dto;





/**
 *
 * DTO used only for posting new users for creation
 *
 */
public class NewUserDTO {

	

	
	private String login;
	private String password;
	private String email;
	
	


    public NewUserDTO() {
    }


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
