package br.com.fatec.alunoapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoResource {
	
	@GetMapping("/alunos")
	public String ola() {
		return "Olá";
	}

}
