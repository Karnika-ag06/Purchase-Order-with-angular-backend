package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

                @RequestMapping(value="/", method=RequestMethod.GET)
                public String getHomePage(ModelMap map)
                {
                                map.addAttribute("msg","Welcome To Purchase Order .....");
                               
                                return "HomePage";
                }

                
                @Autowired
            	HttpServletResponse response;
            	
            	@Autowired
            	HttpServletRequest request;
            	
            	  @RequestMapping(value="/logout",method=RequestMethod.GET)
            	  public String  logout(HttpSession session) {
            		  
            		  response.setHeader("Cache-Control","no-cache");
            		  response.setHeader("Cache-Control","no-store");
            		  response.setHeader("Pragma","no-cache");
            		  response.setDateHeader ("Expires", 0);
            		  session.removeAttribute("userObj");
            		    
            				return "HomePage";
            			
            		      }
            	  }
                

