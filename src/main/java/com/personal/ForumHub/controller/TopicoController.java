package com.personal.ForumHub.controller;

import com.personal.ForumHub.domain.topico.TopicoDTO;
import com.personal.ForumHub.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public void postTopico(@RequestBody @Valid TopicoDTO dados){
        topicoService.criarTopico(dados);
    }
}
