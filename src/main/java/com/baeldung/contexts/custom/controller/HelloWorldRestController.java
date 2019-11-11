package com.baeldung.contexts.custom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.contexts.custom.dto.SaludoDTO;
import com.baeldung.contexts.custom.service.CustomService;

//https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg

@RestController
@RequestMapping("/welcome/")
public class HelloWorldRestController {

	@Autowired
    private CustomService customService;
	
	@GetMapping("/{nombre}")
	public SaludoDTO saludar(@PathVariable String nombre) {
		return customService.saludar(nombre);
	}
	@ResponseBody
	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public SaludoDTO saludarYValidar(@Valid @RequestBody SaludoDTO saludoDTO) {
		return customService.saludarYValidar(saludoDTO);
	}
}
