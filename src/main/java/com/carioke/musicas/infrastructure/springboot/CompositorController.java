package com.carioke.musicas.infrastructure.springboot;

import com.carioke.musicas.domain.Compositor;
import com.carioke.musicas.domain.CompositorListDto;
import com.carioke.musicas.domain.CompositorPostDto;
import com.carioke.musicas.infrastructure.persistence.CompositorRepository;
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
@RequestMapping(path = RestApiRoutes.Compositores.COMPOSITORES)
public class CompositorController {

    @Autowired
    private CompositorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity incluir(@RequestBody @Valid CompositorPostDto dados) {
        repository.save(new Compositor(dados));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public Page<CompositorListDto> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(CompositorListDto::new);
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