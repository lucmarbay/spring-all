package com.baeldung.contexts.custom.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baeldung.contexts.Greeting;

@Service
public class CustomService {

	@Resource
    private Greeting greeting;
    
    public String customGreet(){
    	String message1 = greeting.getMessage();
    	String message2 = " Hola Luciano";
    	String message3 = message1 + message2;
    	greeting.setMessage(message3);
        return greeting.getMessage();
    }
}
