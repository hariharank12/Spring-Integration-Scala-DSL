/**
 * 
 */
package hari.home.springIntegration.SpringIntegration;

/**
 * @author hkumar3
 *
 */
public class Article {

	private final String title;
	private final String content;

	/**
	 * 
	 */
	public Article() {
		this("default title", "default content");
	}

	/**
	 * @param title
	 * @param content
	 */
	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	public String toString() {
		return "[Title=" + this.getTitle() + "][Content=" + this.getContent() + "]";
	}
	
}
