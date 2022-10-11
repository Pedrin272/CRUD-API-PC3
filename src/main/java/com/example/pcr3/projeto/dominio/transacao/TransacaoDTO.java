package com.example.pcr3.projeto.dominio.transacao;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import com.example.pcr3.projeto.dominio.Usuario.UsuarioModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDTO {
    private Boolean ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NonNull
    private String tipo;

    @NonNull
    private Double valor;

    private Double saldo;

    private String descricao;

    @lombok.NonNull
    private UsuarioModel usuario;

}
