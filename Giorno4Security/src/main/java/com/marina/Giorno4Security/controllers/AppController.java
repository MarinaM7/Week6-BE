package com.marina.Giorno4Security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Home page";
	}
	
	@GetMapping("/presentatore")
	@ResponseBody
	@PreAuthorize("hasRole('PRESENTATORE')")
	public String presentatore() {
		return "Page accesso solo Presentatore";
	}
	
	@GetMapping("/cantanti")
	@ResponseBody
	public String cantanti() {
		return "Page accesso Cantanti e Presentatore";
	}
	
	@GetMapping("/pubblico")
	@ResponseBody
	@PreAuthorize("hasRole('PUBBLICO')")
	public String page1() {
		return "Page accesso solo Pubblico";
	}
}
