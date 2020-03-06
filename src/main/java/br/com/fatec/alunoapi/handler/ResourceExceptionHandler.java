/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.alunoapi.handler;

import br.com.fatec.alunoapi.exceptions.AlunoNaoEncontradoException;
import br.com.fatec.alunoapi.model.DetalhesErro;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    	@ExceptionHandler(AlunoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(AlunoNaoEncontradoException e,
			HttpServletRequest req) {

		DetalhesErro erro = new DetalhesErro();

		erro.setStatus(404l);
		erro.setTitulo("O aluno não pode ser encontrado!");
		erro.setMensagemDesenvolvedor("Possível site com manual sobre erros, link para ele");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}
    
}
