package com.personal.ForumHub.domain.topico;

import com.personal.ForumHub.domain.topico.validacoes.ValidadorCriacaoTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    List<ValidadorCriacaoTopico> validadores;

    @Autowired
    TopicoRepository topicoRepository;

    public Topico criarTopico(TopicoDTO dados){
        validadores.forEach(v -> v.validar(dados));
        Topico newTopico = new Topico(dados);

        topicoRepository.save(newTopico);

        return newTopico;
    }

}
