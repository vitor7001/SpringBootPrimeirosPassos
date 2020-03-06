package br.com.fatec.alunoapi.resource;

import br.com.fatec.alunoapi.exceptions.AlunoNaoEncontradoException;
import java.util.List;

import br.com.fatec.alunoapi.model.Aluno;
import br.com.fatec.alunoapi.repository.AlunoRepository;
import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping()
    public ResponseEntity<List<Aluno>> ola() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody Aluno aluno) {

        aluno = alunoRepository.save(aluno);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {

        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (!aluno.isPresent()) {
            throw new AlunoNaoEncontradoException("O aluno não pode ser encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

        alunoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Aluno aluno, @PathVariable("id") Long id) {
        aluno.setId(id);

        alunoRepository.save(aluno);

        return ResponseEntity.noContent().build();
    }

}
