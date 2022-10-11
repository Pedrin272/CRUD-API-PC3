package com.example.pcr3.projeto.dominio.transacao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.pcr3.projeto.dominio.Usuario.UsuarioModel;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean ativo;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String tipo;

    private Double valor;

    private Double saldo;

    private String descricao;

    @lombok.NonNull
    private UsuarioModel usuario;
}
