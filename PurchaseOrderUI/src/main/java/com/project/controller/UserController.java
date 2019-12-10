package com.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.User;
import com.project.service.UserService;

@Controller
public class UserController {
                
                
                @Autowired
                UserService userService;
                

                
//=====open register form========
                
                @RequestMapping(value="/getRegisterForm" , method=RequestMethod.GET)
                public String getRegisterForm(ModelMap map)
                {
                                map.addAttribute("userObj",new User());
                                return "Register";
                }
                
//=======register the buyer=========
                
                @RequestMapping(value="/registerUser",method=RequestMethod.POST)
                public ModelAndView addRegister(@Valid @ModelAttribute("userObj") User userObj,BindingResult result )
                {
                	           //if role
                	if(result.hasErrors())
                	{
                		ModelAndView mv=new ModelAndView("Register");
                		return mv;
                	}
                	else {
                		userService.addUser(userObj);    //method call to service method 
        				ModelAndView mv=new ModelAndView("success");
        				return mv;
                	}
                              
                }

                
//=======open login form=========
                
                @RequestMapping(value="/getLoginForm",method=RequestMethod.GET)
                public String getLoginForm()
                {
                                return "LoginForm";
                }
                
                
//======login buyer==========
                
                @Autowired
                HttpSession session;
                
              @RequestMapping(value="/validate", method =RequestMethod.POST)
            public String validateUser(@RequestParam String email ,@RequestParam String pass)
           	{
           		User uObj = userService.validateUser(email, pass);
           		
           		if(uObj==null)
           		{
           			return "Register";
           		}
           		else {
           			
           			session.setAttribute("uObj",uObj);
           			if(uObj.getUserRole().equals("Buyer"))
           			{
           			
           			return "BuyerPage";
           			}
           			else if(uObj.getUserRole().equalsIgnoreCase("Vendor")) {
           				
           				return "VendorPage";
           			}
           			
           			else
           			{
           				return "sellersuccess";
           			}
           		}
           	 }
           	
           }
