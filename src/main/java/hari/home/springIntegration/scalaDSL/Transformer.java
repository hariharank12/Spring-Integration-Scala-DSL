/**
 * 
 */
package hari.home.springIntegration.scalaDSL;

import org.springframework.integration.Message;

/**
 * @author hkumar3
 *
 */
public class Transformer {
	
	public String transform(Message<String> message) {
		return message.getPayload() + " Scala";
	}

}
