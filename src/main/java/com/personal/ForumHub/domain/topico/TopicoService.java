package com.personal.ForumHub.domain.topico;

import com.personal.ForumHub.domain.topico.validacoes.ValidacaoException;
import com.personal.ForumHub.domain.topico.validacoes.ValidadorCriacaoTopico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    List<ValidadorCriacaoTopico> validadores;

    @Autowired
    TopicoRepository topicoRepository;

    @Transactional
    public Topico criarTopico(TopicoDTO dados){
        validadores.forEach(v -> v.validar(dados));
        Topico newTopico = new Topico(dados);

        topicoRepository.save(newTopico);

        return newTopico;
    }

    @Transactional
    public TopicoDTO updateTopico(UpdateTopicoDTO newData, Long id){

        var topico = topicoRepository.getReferenceById(id);
        var topicoAux = new Topico(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getEstado(), topico.getAutor(), topico.getCurso());
        topicoAux.updateInfo(newData);

        TopicoDTO dadosAux = new TopicoDTO(topicoAux);
        validadores.forEach(v -> v.validar(dadosAux));

        topico.updateInfo(newData);
        return dadosAux;
    }

}
