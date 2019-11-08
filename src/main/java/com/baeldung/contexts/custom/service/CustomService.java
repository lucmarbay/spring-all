package com.baeldung.contexts.custom.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import com.baeldung.contexts.CustomGreeting;
import com.baeldung.contexts.Greeting;

@Service
public class CustomService {

//	@Autowired
//	@Qualifier("greeting")
	private Greeting greeting;
	
//	@Autowired
//	@Qualifier("customGreeting")
    private Greeting customGreeting;
	
	public CustomService(Greeting greeting, Greeting customGreeting) {
		this.greeting = greeting;
		this.customGreeting = customGreeting;
	}
    
    public String customGreet(){
    	String message1 = this.greeting.getMessage();
    	String message2 = this.customGreeting.getMessage();
    	String message3 = message1 + message2;
        return message3;
    }
}
