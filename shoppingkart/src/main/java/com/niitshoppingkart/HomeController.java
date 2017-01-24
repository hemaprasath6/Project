package com.niitshoppingkart;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.Model.User;
import com.niit.UserDAO.UserDAO;


@Controller
public class HomeController {
	//need to call methods of USERDAOimpl- so autowired

	
	
	@Autowired
User user;

@Autowired
UserDAO userDAO;

	
	
	@RequestMapping("/")
public ModelAndView homepage()
{
	ModelAndView mv = new ModelAndView("home");
	return mv;
	}
	@RequestMapping("/login")
	public ModelAndView showLoginPage()
	{//modelandview- to which page to navigate
		//what data need to be carried
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "You clicked login page");
		mv.addObject("showLoginPage", "true");
		return mv;
	}
	
@RequestMapping("/register")
public ModelAndView showRegistrationPage()
{
	ModelAndView mv = new ModelAndView("home");
	mv.addObject("msg", "registration");
	mv.addObject("showRegistrationPage", "true");
	return mv;
}

@RequestMapping("/validate")
public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String pwd){
	System.out.println("In validate Method");
	System.out.println("id:" +id);
	System.out.println("pwd:" +pwd);
	ModelAndView mv = new ModelAndView("login"); 
	/*
	if(userDAO.validate(id,pwd)!=null)
	{
		mv.addObject("succesmsg", "you logged in succesfully");
	}
	else
	{
		mv.addObject("errormsg", "invalidate credentials");
	}*/
	
	User p =  userDAO.get(id);
	if(p.getPassword().equals(pwd)){
	mv.addObject("loginsuccess", "successfully logged in");
	
	}
	else
	{
		mv.addObject("loginfailed", "invalid credentials");
		return mv;
	}
	
	return mv;
	
	
	
	
	}
}


