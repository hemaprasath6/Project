package com.niit.Controller;

import java.util.List;
import java.util.Map;
 
import com.niit.controller.User;
import com.niit.quickstart.dao.UserDao;
import com.niit.quickstart.impl.UserDaoImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView
@Controller
public class RegisterController {

    @RequestMapping(value="/register" ,method = RequestMethod.POST)
    public ModelAndView viewRegistration(@ModelAttribute("obj") User usrobj) {
       
    	ModelAndView model=new ModelAndView("RegistrationSuccess");
    	return model;
    	/*
    	model.put("userForm", userForm);
        /* 
        List<String> professionList = new ArrayList();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.put("professionList", professionList);
         
        return "Registration";*/
    }
     /*
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("birth date: " + user.getBirthDate());
        System.out.println("profession: " + user.getProfession());
         
        return "RegistrationSuccess";
    }*/
    
    @RequestMapping("/loginsuccess")
    public ModelAndView hello(@RequestParam ("usr") String usr,@RequestParam("pwd") String pwd){
    	UserDao userobj=new UserDaoImpl();
    	if(userobj.isValidCredentials(usr,pwd)){
    		ModelAndView model=new ModelAndView("loginsuccess");
    		return model;    	
    	}
    	ModelAndView model=new ModelAndView("login");
		return model;    	

    }
}


