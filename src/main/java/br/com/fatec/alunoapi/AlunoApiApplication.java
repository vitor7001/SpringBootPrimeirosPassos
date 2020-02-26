package br.com.fatec.alunoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.fatec.alunoapi"})
public class AlunoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApiApplication.class, args);
	}

}
