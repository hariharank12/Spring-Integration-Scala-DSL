/**
 * 
 */
package hari.home.springIntegration.SpringIntegration;

/**
 * @author hkumar3
 *
 */
public class Formater {

	public String getTechnologyName() {
		StringBuilder message = new StringBuilder();
		message.append("Spring Integration in Scala ");
		return message.toString();
	}
	
	public String format(String s) {
        return s.concat(" , ").concat(getTechnologyName());
    }	
	
	

}
