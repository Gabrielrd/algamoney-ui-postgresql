package com.example.algamoneyapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.algamoneyapi.Repository.lancamento.LancamentoRepositoryQuery;
import com.example.algamoneyapi.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
