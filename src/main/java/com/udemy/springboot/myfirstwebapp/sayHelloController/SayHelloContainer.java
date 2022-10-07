package com.udemy.springboot.myfirstwebapp.sayHelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloContainer {

	
	@RequestMapping("sayhello")
	@ResponseBody
	public String response()
	{
		return "Hello What are you learning today!!";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String htmlresponse()
	{
		StringBuffer  sb = new StringBuffer();
		sb.append("<html><title>My first html page</title><body>The body of my html page</body></html>");
		//sb.append("<html>");sb.append("<html>");sb.append("<html>");sb.append("<html>");
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	 
	public String  jspresponse()
	{
		 
		return "sayHello";
	}
}
