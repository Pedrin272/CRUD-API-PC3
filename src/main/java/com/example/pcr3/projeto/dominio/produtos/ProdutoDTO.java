package com.example.pcr3.projeto.dominio.produtos;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.example.pcr3.projeto.dominio.Usuario.UsuarioModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private long id;
    @NonNull
    private String nome;

    private Double valorVenda;

    @NonNull
    private Double estoque;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
    @ManyToOne
    @NonNull
    private UsuarioModel usuario;
}
