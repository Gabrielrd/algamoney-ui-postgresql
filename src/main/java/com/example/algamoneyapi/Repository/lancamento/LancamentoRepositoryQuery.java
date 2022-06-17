package com.example.algamoneyapi.Repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.algamoneyapi.Repository.filter.LancamentoFilter;
import com.example.algamoneyapi.Repository.projection.ResumoLancamento;
import com.example.algamoneyapi.model.Lancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
