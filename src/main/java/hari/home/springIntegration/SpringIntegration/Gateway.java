/**
 * 
 */
package hari.home.springIntegration.SpringIntegration;

/**
 * @author hkumar3
 * 
 */
/*
 * public interface Gateway<T> {
 * 
 * boolean send(T s);
 * 
 * }
 */

public interface Gateway {

	void send(String s);

}


/*public interface Gateway<T1, T2> {

	T1 send(T2 s);

}
*/