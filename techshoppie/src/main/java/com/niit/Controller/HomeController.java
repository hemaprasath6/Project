package com.niit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/about")
	public String showAboutUs()
	{
		return "aboutus";
	}
	
	@RequestMapping("/registration")
	public String showregistration()
	{
		return "registration";
	}

	@RequestMapping("/login")
	public String showlogin()
	{
		return "login";
	}
}

