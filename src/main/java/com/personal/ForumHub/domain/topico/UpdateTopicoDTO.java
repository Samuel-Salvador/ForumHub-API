package com.personal.ForumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateTopicoDTO (

    String titulo,

    String mensagem,

    LocalDateTime data,

    String estado,

    String autor,

    String curso
) {}

