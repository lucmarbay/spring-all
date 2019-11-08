package com.baeldung.contexts.custom.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.baeldung.contexts.custom.service.CustomService;
import com.baeldung.contexts.services.GreeterService;

@Controller
public class CustomHelloWorldController {
	@Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private CustomService customService;
    
    private void processContext() {
        WebApplicationContext rootContext = ContextLoader.getCurrentWebApplicationContext();
        
        System.out.println("root context : " + rootContext);
        System.out.println("root context Beans: " + Arrays.asList(rootContext.getBeanDefinitionNames()));

        System.out.println("context : " + webApplicationContext);
        System.out.println("context Beans: " + Arrays.asList(webApplicationContext.getBeanDefinitionNames()));
    }

    @RequestMapping(path = "/welcome")
    public ModelAndView helloWorld() {
        processContext();
        String message = "<br><div style='text-align:center;'>" + "<h3>Custom " + customService.customGreet() + "</h3></div>";
        return new ModelAndView("customWelcome", "message", message);
    }
}
