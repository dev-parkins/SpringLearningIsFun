package restTests;

import org.springframework.hateoas.ResourceSupport;

public class Greeting2 extends ResourceSupport{
	private final String content;
	
	public Greeting2(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
}