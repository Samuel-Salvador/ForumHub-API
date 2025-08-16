package com.personal.ForumHub.domain.topico.validacoes;

import com.personal.ForumHub.domain.topico.TopicoDTO;

public interface ValidadorCriacaoTopico {

    void validar(TopicoDTO dados);
}
