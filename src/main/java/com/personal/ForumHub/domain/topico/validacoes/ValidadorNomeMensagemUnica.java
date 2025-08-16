package com.personal.ForumHub.domain.topico.validacoes;

import com.personal.ForumHub.domain.topico.TopicoDTO;
import com.personal.ForumHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorNomeMensagemUnica implements ValidadorCriacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(TopicoDTO dados) {
        var topicoDuplicado = ! topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if (!topicoDuplicado){
            throw new ValidacaoException("Já existe um tópico com este título e mensagem");
        }
    }
}
