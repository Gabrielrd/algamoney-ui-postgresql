package com.example.algamoneyapi.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.Repository.PessoaRepository;
import com.example.algamoneyapi.model.Pessoa;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		
		Pessoa pessoaSalva = BuscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = BuscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
		
	}
	
	private Pessoa BuscarPessoaPeloCodigo(Long codigo) {
		if (!pessoaRepository.existsById(codigo)) {
			throw new EmptyResultDataAccessException(1);
		}
		Pessoa pessoaSalva = pessoaRepository.findById(codigo).get();
		return pessoaSalva;
	}	
	
}
