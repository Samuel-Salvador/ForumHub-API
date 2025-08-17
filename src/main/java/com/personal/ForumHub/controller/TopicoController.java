package com.personal.ForumHub.controller;

import com.personal.ForumHub.domain.topico.TopicoDTO;
import com.personal.ForumHub.domain.topico.TopicoRepository;
import com.personal.ForumHub.domain.topico.TopicoService;
import com.personal.ForumHub.domain.topico.UpdateTopicoDTO;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity postTopico(@RequestBody @Valid TopicoDTO dados, UriComponentsBuilder uriBuilder){

        var topico = topicoService.criarTopico(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<TopicoDTO>> getAllTopicos(){
        var topicoList = topicoRepository.findAll();
        var topicoDTOList = topicoList.stream().map(TopicoDTO::new).toList();

        return ResponseEntity.ok(topicoDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> getEspecificTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new TopicoDTO(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> updateTopico(@PathVariable Long id, @RequestBody @Valid UpdateTopicoDTO dados){
        var updatedTopico = topicoService.updateTopico(dados, id);

        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopico(@PathVariable Long id) {
        var topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isEmpty()) return ResponseEntity.notFound().build();

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
