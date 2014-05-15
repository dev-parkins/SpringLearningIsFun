package restTests;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * Since Jackson 2 is on the classpath, automatically returns greeting in JSON format
 * 
 * Also, this controller returns information on the resource depending on its list of
 * fields that it has for itself
 */
@Controller
public class GreetingController {
	private static final String TEMPLATE = "Hello, %s!";
	private static final String TEMPLATE2 = "Your request method is: %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting") //requests such as localhost/greeting requests are sent to this controller
	@ResponseBody
	public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="Banana") String name){
		return new Greeting(counter.incrementAndGet(),
			String.format(TEMPLATE, name));
	}
	
	@RequestMapping("/greeting2")
	@ResponseBody
	public HttpEntity<Greeting2> greeting2(@RequestParam(value = "name", required = false, defaultValue = "Banana") String name){
		Greeting2 greeting = new Greeting2(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		return new ResponseEntity<Greeting2>(greeting, HttpStatus.OK);
	}
	
	@RequestMapping("/greeting3")
	@ResponseBody
	public HttpEntity<Greeting2> greeting3(@RequestParam(value="requestType", required=true) String requestType){
		Greeting2 greeting = new Greeting2(String.format(TEMPLATE2, requestType));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(requestType)).withSelfRel());
		return new ResponseEntity<Greeting2>(greeting, HttpStatus.OK);
	}
}
