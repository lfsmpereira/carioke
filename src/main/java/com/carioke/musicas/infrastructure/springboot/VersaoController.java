package com.carioke.musicas.infrastructure.springboot;

import com.carioke.musicas.domain.*;
import com.carioke.musicas.infrastructure.persistence.InterpreteRepository;
import com.carioke.musicas.infrastructure.persistence.MusicaRepository;
import com.carioke.musicas.infrastructure.persistence.VersaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = RestApiRoutes.Versoes.VERSOES)
public class VersaoController {

    @Autowired
    private VersaoRepository repository;
    @Autowired
    private MusicaRepository musicaRepository;
    @Autowired
    private InterpreteRepository interpreteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity incluir(@RequestBody @Valid VersaoPostDto dados) {
        Musica musica = musicaRepository.getReferenceById(dados.musica_id());
        List<Interprete> interpretes = dados.interpretes_ids().stream().map(i->(interpreteRepository.getReferenceById(i))).toList();
        repository.save(new Versao(musica, interpretes));
        return new ResponseEntity(HttpStatus.CREATED);
    }
/*
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

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