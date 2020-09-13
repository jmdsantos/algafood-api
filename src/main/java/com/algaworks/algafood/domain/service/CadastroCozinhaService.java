package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	private static final String MSG_COZINHA_EM_USO 
		= "Cozinha de código %d não pode ser removida, pois esta em uso.";

	private static final String MSG_COZINHA_NAO_ENCONTRADA 
		= "Não existe cadastro de cozinha com código %d";
	
	@Autowired
	private CozinhaRepository cozinhasRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhasRepository.save(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhasRepository.deleteById(cozinhaId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_COZINHA_EM_USO, cozinhaId));
		}
	}
	
	public Cozinha buscarOrFalhar(Long cozinhaId) {
		return cozinhasRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_COZINHA_NAO_ENCONTRADA));
	}
}
