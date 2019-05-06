package com.satish.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTMl form.
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read the data from the form.
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		//read the request parameter from the HTML form 
		String theName= request.getParameter("studentName");
		//convert the data into all CAPS
		theName = theName.toUpperCase();
		//create the message
		String result ="Yo!  "+ theName;
		//add message to the model
		
		model.addAttribute("message", result);
		return "helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//convert the data into all CAPS
		theName = theName.toUpperCase();
		//create the message
		String result ="From Version 3!!!  "+ theName;
		//add message to the model
		
		model.addAttribute("message", result);
		return "helloworld";
	}


}
