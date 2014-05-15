package springapp;

import interfaces.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="messagePrinter")
public class MessagePrinter {
	@Autowired //Apparently used to avoid constructor
	private MessageService service;
	
	public void printMessage(){
		System.out.println(this.service.getMessage());
	}
}
