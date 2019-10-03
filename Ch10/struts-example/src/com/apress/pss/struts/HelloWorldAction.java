package com.apress.pss.struts;
	
import javax.servlet.http.HttpServletRequest;   
import org.apache.struts2.ServletActionContext;  
	 
	 public class HelloWorldAction {  
	      private String username;  

	      public String execute() {  
	           HttpServletRequest request = ServletActionContext.getRequest();  
	           this.setUsername(request.getUserPrincipal().getName());  
	            return "SUCCESS";  
	   }  
	      public String getUsername() {  
	           return username;  
	      }  
	      public void setUsername(String username) {  
	           this.username = username;  
	      }  
}  