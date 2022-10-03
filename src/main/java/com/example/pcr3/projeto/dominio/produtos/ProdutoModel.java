package com.example.pcr3.projeto.dominio.produtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("nome")
    @Column(name = "nome", nullable = false)
    private String nome;

    @JsonProperty("valorVenda")
    @Column(name = "valor_venda", nullable = false)
    private Double valorVenda;

    @JsonProperty("estoque")
    @Column(name = "estoque", nullable = false)
    private Double estoque;
}
