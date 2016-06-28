package com.danco.service;

import com.danco.model.User;


public class Test {
public static void main(String[] args) {
		
		UserService us=new UserService();
	User user=	us.getByCredentials("root", "1111");
	System.out.println(user.getId());
	}
}
