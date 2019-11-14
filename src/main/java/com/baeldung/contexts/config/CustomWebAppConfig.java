package com.baeldung.contexts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.baeldung.contexts.Greeting;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.baeldung.contexts.custom", "com.everis.demo.autoconfigure"})
public class CustomWebAppConfig {

	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
	
	@Bean
    public Greeting customGreeting() {
		Greeting customGreeting = new Greeting();
		customGreeting.setMessage(" Hola Luciano !!");
        return customGreeting;
    }
}
