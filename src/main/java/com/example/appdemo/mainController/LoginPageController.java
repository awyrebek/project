package com.example.appdemo.mainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class LoginPageController
{
	@GET
	@RequestMapping
	public String showLoginPage()
	{
		return "login";
	}
}
