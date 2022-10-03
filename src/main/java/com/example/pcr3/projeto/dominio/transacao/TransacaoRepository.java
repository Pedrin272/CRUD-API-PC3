package com.example.pcr3.projeto.dominio.transacao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends PagingAndSortingRepository<TransacaoModel, Long> {
}
