/**
 * 
 */
package hari.home.springIntegration.scalaDSL;

import org.springframework.integration.Message;

import hari.home.springIntegration.SpringIntegration.Article;

/**
 * @author hkumar3
 * 
 */
public class Filter {

	public boolean trap(Message<String> message) {
		
		String filterMessage = (String) message.getPayload();
		//return (t.getTitle().equalsIgnoreCase("default title"));
		boolean status = filterMessage.equalsIgnoreCase("hello");
		System.out.println("I am reaching filter trap" + filterMessage + " : status " + status);
		
		return status;
	}

}
