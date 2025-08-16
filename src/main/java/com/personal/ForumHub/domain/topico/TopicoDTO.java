package com.personal.ForumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTO(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        LocalDateTime data,

        @NotBlank
        String estado,

        @NotBlank
        String autor,

        @NotBlank
        String curso
) {

    public TopicoDTO(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getEstado(), topico.getAutor(), topico.getCurso());
    }
}
