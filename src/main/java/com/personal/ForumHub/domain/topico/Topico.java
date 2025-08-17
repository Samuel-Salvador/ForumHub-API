package com.personal.ForumHub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Column (name = "data_de_criacao")
    private LocalDateTime data;

    @Column (name = "estado_do_topico")
    private String estado;

    private String autor;
    private String curso;

    public Topico(TopicoDTO dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = dados.data();
        this.estado = dados.estado();
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public void updateInfo(UpdateTopicoDTO dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.data() != null){
            this.data = dados.data();
        }
        if (dados.estado() != null){
            this.estado = dados.estado();
        }
        if (dados.autor() != null){
            this.autor = dados.autor();
        }
        if (dados.curso() != null){
            this.curso = dados.curso();
        }
    }
}
