/**
 * 
 */
package hari.home.springIntegration.SpringIntegration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;
import org.springframework.util.Assert;

/**
 * @author hkumar3
 * @param <T>
 *
 */
public class ArticleMessage<T> implements Message<T> {

//	private static final long serialVersionUID = 3649200745084232821L;

	private final T payload;

	private final MessageHeaders headers;
	
	/**
	 * 
	 */
	public ArticleMessage(T payload) {
		this(payload, null);
	}

	public ArticleMessage(T payload, Map<String, Object> headers) {
		super();
		Assert.notNull(payload, "payload must not be null");
		if (headers == null) {
			headers = new HashMap<String, Object>();
		}
		else {
			headers = new HashMap<String, Object>(headers);
		}
		this.headers = new MessageHeaders(headers);
		this.payload = payload;
	}

	@Override
	public MessageHeaders getHeaders() {
		return this.headers;
	}

	@Override
	public T getPayload() {
		return this.payload;
	}

	public String toString() {
		return "[Payload=" + this.payload + "][Headers=" + this.headers + "]";
	}
	
}
