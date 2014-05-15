package restTests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/*
 * In order to run application, must use mvn spring-boot:run to boot up the rest service, then
 * use localhost:8080/greeting to access the REST service
 */
@ComponentScan //Scans through restTests package to find associated controllers
@EnableAutoConfiguration //default behaviors based on class path
public class GreetingApplication {
	public static void main(String[] args){
		SpringApplication.run(GreetingApplication.class, args);
	}
}