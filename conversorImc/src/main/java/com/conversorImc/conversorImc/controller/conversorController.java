package com.conversorImc.conversorImc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conversorImc.conversorImc.service.conversorService;

@Controller
public class conversorController {
	
	@Autowired
	private conversorService ConversorService;
	
	@GetMapping({"/", "/form"})
	public String showForm() {
		return "form";
	}
	
	@PostMapping({"/","/form"})
	public String calculoImcController(@RequestParam Optional <String> weight, @RequestParam Optional <String> age, @RequestParam Optional <String> sexo, 
							@RequestParam Optional <String> heigth, Model model ) throws Exception{
		
		String result = ConversorService.calculoImc(weight, age, sexo, heigth, model);
		
		model.addAttribute("result", result);
		
		
		return "form";
	}
}
