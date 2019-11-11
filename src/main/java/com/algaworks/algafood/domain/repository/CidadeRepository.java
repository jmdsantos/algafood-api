package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;

public interface CidadeRepository {
	
	List<Cidade> listar(Estado estado);
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade Cidade);
	
}
