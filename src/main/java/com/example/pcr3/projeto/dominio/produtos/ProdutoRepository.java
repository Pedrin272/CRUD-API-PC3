package com.example.pcr3.projeto.dominio.produtos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoModel, Long> {
}

