package com.conversorImc.conversorImc.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class conversorService {
	
	public String calculoImc(@RequestParam Optional <String> weight, @RequestParam Optional <String> age, @RequestParam Optional <String> sexo, 
							@RequestParam Optional <String> heigth, Model model ) throws Exception {
		String result = "";
		if(!weight.isEmpty() && !age.isEmpty() && !sexo.isEmpty() && !heigth.isEmpty()) {
			try {
			Integer weight1 = Integer.parseInt(weight.get());
			Integer age1 = Integer.parseInt(age.get());
			Integer height1 = Integer.parseInt(heigth.get());
			
			
			String sex = sexo.get();
			
			Integer imc = weight1 / height1 * height1;
			
			if(age1 >= 25) {
				if(imc < 18.5) {
					result = "Bajo peso.";
				}else if(imc >= 18.5 || imc <= 24.9) {
					result = "Peso normal.";
				}else if(imc >= 25 || imc <= 29.9) {
					result = "Sobre peso.";
				}else {
					result = "Obesidad.";
				}
			}else {
				if(imc < 17.5) {
					result = "Bajo peso.";
				}else if(imc >= 17.5 || imc <= 26.9) {
					result = "Peso normal.";
				}else if(imc >= 26 || imc <= 32.9) {
					result = "Sobre peso.";
				}else {
					result = "Obesidad.";
				}
			}
			}catch (Exception error) {
				throw new Exception ("Datos no validos.");
			}
		}
		return result;
	}

}
