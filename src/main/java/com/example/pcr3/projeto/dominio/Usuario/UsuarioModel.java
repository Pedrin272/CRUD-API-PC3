package com.example.pcr3.projeto.dominio.Usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.pcr3.projeto.dominio.Model.Model;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioModel extends Model implements Serializable {

    @Column(nullable = false)
    private String nome;

    private String sobrenome;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String cpf;

    @ManyToOne
    @NonNull
    private UsuarioModel usuario;
}