package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	private static final String MSG_RESTAURANTE_NAO_EXISTE 
		= "Não existe cadastro de Restaurante com o código %d";

	@Autowired
	private RestauranteRepository restaurantesRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	public Restaurante salvar(Restaurante restaurante) {
		
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cadastroCozinha.buscarOrFalhar(cozinhaId);
		
		restaurante.setCozinha(cozinha);
		
		return restaurantesRepository.save(restaurante);
	}
	
	public Restaurante BuscarOuFalhar(Long restauranteId) {
		return restaurantesRepository.findById(restauranteId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format(MSG_RESTAURANTE_NAO_EXISTE, restauranteId)));
	}
	
}
