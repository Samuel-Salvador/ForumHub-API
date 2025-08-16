package com.personal.ForumHub.controller;

import com.personal.ForumHub.domain.topico.TopicoDTO;
import com.personal.ForumHub.domain.topico.TopicoRepository;
import com.personal.ForumHub.domain.topico.TopicoService;
import jakarta.validation.Valid;
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
}
