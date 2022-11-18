package com.carioke.musicas.infrastructure.springboot;

import com.carioke.musicas.domain.*;
import com.carioke.musicas.infrastructure.persistence.InterpreteRepository;
import com.carioke.musicas.infrastructure.persistence.MusicaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = RestApiRoutes.Interpretes.INTERPRETES)
public class InterpreteController {

    @Autowired
    private InterpreteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity incluir(@RequestBody @Valid InterpretePostDto dados) {
        repository.save(new Interprete(dados));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public Page<InterpreteListDto> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(InterpreteListDto::new);
    }
/*
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    @RequestMapping(method = RequestMethod.PATCH, path = User.USER_DETAILS)
    public ResponseEntity user(
            @PathVariable(value = "userId") UUID userId,
            @RequestBody @Validated ChangeUserDetailsCommand command){
        command.setUserId(userId);
        this.executeCommand(command);
        return new ResponseEntity(HttpStatus.OK);
    }
*/
}