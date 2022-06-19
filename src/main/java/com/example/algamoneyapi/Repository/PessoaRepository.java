package com.example.algamoneyapi.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.example.algamoneyapi.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	 public Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);

}
