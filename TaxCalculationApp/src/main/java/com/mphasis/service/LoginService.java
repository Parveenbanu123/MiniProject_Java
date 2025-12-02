package com.mphasis.service;

import com.mphasis.model.Login;

public class LoginService {

	Login login=new Login();
	public boolean loginValidate(String username,String password) {
		return login.getUsername().equals(username) && login.getPassword().equals(password);
	}
	
	public void welcome() {
		 String title="WELCOME TO TAX CALCULATION APP";
		System.out.print("+");
		for(int i=0;i<34;i++)System.out.print("-");
		System.out.print("+");
		
		System.out.println();
		System.out.print("|  "+title +"  |");
		System.out.println();
		
		System.out.print("+");
		for(int i=0;i<34;i++)System.out.print("-");
		System.out.print("+");
		System.out.println();
		
		System.out.println("PLEASE LOGIN TO CONTINUE :-)");
		
	}
}
