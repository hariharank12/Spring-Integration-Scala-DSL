/**
 * 
 */
package hari.home.springIntegration.runner;

import hari.home.springIntegration.SpringIntegration.Article;
import hari.home.springIntegration.SpringIntegration.ArticleMessage;
import hari.home.springIntegration.SpringIntegration.Gateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;



/**
 * @author hkumar3
 *
 */
public class Bootstrap {

	static Article getDefaultArticle() {
		Article article = new Article();
		return article;
	}
	
	public Bootstrap channelSample() {
		System.out.println("channelSample .......................");
	    ApplicationContext context = new ClassPathXmlApplicationContext("config/config_channel.xml");
	    PollableChannel channel = (PollableChannel) context.getBean("channel");
	    Message<String> m = MessageBuilder.withPayload("helloWorld").build();
	    //MessageBuilder.withPayload("helloWorld").;
	    channel.send(m);
	    channel.send(new ArticleMessage<Article>(getDefaultArticle()));
	    
	    Message<?> reply = channel.receive();
	    System.out.println("received1: " + reply);
	    reply = channel.receive();
	    System.out.println("received2: " + reply);
	    
		context = null;
		channel = null;
		
	    return this;
	}
	
	public Bootstrap channelServiceActivator() {
		System.out.println("channelServiceActivator .......................");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"config/config_serviceActivator.xml");
		//input channel
		MessageChannel input = (MessageChannel) context.getBean("input");
		
		//output channel
		PollableChannel output = (PollableChannel) context.getBean("output");
		
		Message<String> inputMessage = MessageBuilder.withPayload("helloWorld").build();
		System.out.println("Payload of input message -> " + inputMessage.getPayload());
		input.send(inputMessage);
		
/*		Message<?> outputMessageShouter = output.receive();
		System.out.println("Class type of output message -> " + outputMessageShouter.getClass());
		System.out.println("Payload of output message -> " + outputMessageShouter.getPayload());
*/		
		Message<?> outputMessageFormater = output.receive(10);
		System.out.println("Class type of output message -> " + outputMessageFormater.getClass());
		System.out.println("Payload of output message -> " + outputMessageFormater.getPayload());
		
		context = null;
		input = null;
		output = null;
		
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public Bootstrap channelServiceActivatorWithGateway() {
		System.out.println("channelServiceActivatorWithGateway .......................");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"config/config_serviceActivator.xml");
		//input channel
		//Gateway<String> gateway = (Gateway<String>) context.getBean("gateway");
		//Gateway<String, String> gateway = (Gateway<String, String>) context.getBean("gateway");
		Gateway gateway = (Gateway) context.getBean("gateway");
		
		//output channel
		PollableChannel output = (PollableChannel) context.getBean("output");
		
		Message<String> inputMessage = MessageBuilder.withPayload("helloWorld").build();
		System.out.println("Payload of input message -> " + inputMessage.getPayload());
		gateway.send(inputMessage.toString());
		
/*		Message<?> outputMessageShouter = output.receive();
		System.out.println("Class type of output message -> " + outputMessageShouter.getClass());
		System.out.println("Payload of output message -> " + outputMessageShouter.getPayload());
*/		
		Message<?> outputMessageFormater = output.receive(10);
		System.out.println("Class type of output message -> " + outputMessageFormater.getClass());
		System.out.println("Payload of output message -> " + outputMessageFormater.getPayload());

		return this;
		
	}

	public Bootstrap channelServiceActivatorWithGatewayAndScalaDSL() {
		System.out.println("channelServiceActivatorWithGatewayAndScalaDSL .......................");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"config/config_scalaDSL.xml");
		//input channel
		//Gateway<String> gateway = (Gateway<String>) context.getBean("gateway");
		//Gateway<String, String> gateway = (Gateway<String, String>) context.getBean("gateway");
		//Gateway gateway = (Gateway) context.getBean("gateway");

		//input channel
		MessageChannel input = (MessageChannel) context.getBean("input");
		
		//output channel
//		PollableChannel output = (PollableChannel) context.getBean("output");
		
		Message<String> inputMessage = MessageBuilder.withPayload("hello").build();
		System.out.println("Payload of input message -> " + inputMessage.getPayload());
		input.send(inputMessage);
		
/*		Message<?> outputMessageShouter = output.receive();
		System.out.println("Class type of output message -> " + outputMessageShouter.getClass());
		System.out.println("Payload of output message -> " + outputMessageShouter.getPayload());
*/		
/*		Message<?> outputMessageFormater = output.receive(10);
		System.out.println("Class type of output message -> " + outputMessageFormater.getClass());
		System.out.println("Payload of output message -> " + outputMessageFormater.getPayload());
*/
		return this;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bootstrap bootstrap = new Bootstrap();
		//bootstrap.channelSample().channelServiceActivator().channelServiceActivatorWithGateway().channelServiceActivatorWithGatewayAndScalaDSL();
		//bootstrap.channelSample();
		//bootstrap.channelServiceActivator();
		//bootstrap.channelServiceActivatorWithGateway();
		//bootstrap.channelServiceActivatorWithGatewayAndScalaDSL();
		BootstrapScala.springDSL();
		BootstrapScala.springDSLMessageFlow();
	}

}
