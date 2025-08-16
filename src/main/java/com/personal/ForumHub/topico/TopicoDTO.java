package com.personal.ForumHub.topico;

import java.time.LocalDateTime;

public record TopicoDTO(Long id,
                        String titulo,
                        String mensagem,
                        LocalDateTime data,
                        String estado,
                        String autor,
                        String curso) {
}
