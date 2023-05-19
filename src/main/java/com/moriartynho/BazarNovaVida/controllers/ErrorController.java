package com.moriartynho.BazarNovaVida.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	
	@GetMapping("error")
	public String erro() {
		return "erro";
	}

}
