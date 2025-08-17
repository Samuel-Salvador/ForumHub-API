package com.personal.ForumHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(@NotBlank String login, @NotBlank String senha) {
}
