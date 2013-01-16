/**
 * 
 */
package hari.home.springIntegration.scalaDSL;

import org.springframework.integration.Message;

/**
 * @author hkumar3
 *
 */
public class ConsolePrinter {
	
	public void display(Message<String> message) {
		System.out.println("I am in console printer class and display method");
		System.out.println(message.getPayload());
	}

}
