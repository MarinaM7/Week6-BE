package com.marina.Giorno2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GestioneController {

	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "ciao sono home";
	}
	
	@GetMapping("/info/{segment}")
	@ResponseBody
	public String end2(@PathVariable String segment) {
		
		String x;
		
		switch (segment) {
		case "it":
			x = "Regole in italiano";
			break;
			
		case "en":
			x = "Rules in english";
			break;
			
		default:
			x = "Language not supported.";
		}
	return x;
	}
	
	
}
