package com.mphasis.controller;

import com.mphasis.Read;

import com.mphasis.service.LoginService;

public class LoginController {

	LoginService login=new LoginService();

	public boolean validate() {
		
		login.welcome();
		System.out.print("USERNAME :");
		String username = Read.sc.nextLine();
		System.out.print("PASSWORD :");
		String password= Read.sc.nextLine();
		return login.loginValidate(username, password);
	}
}
