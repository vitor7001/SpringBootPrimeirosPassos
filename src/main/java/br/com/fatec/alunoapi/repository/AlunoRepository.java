package br.com.fatec.alunoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.alunoapi.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
