package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping(value = "/teste") 
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cosinhasPorNome(String nome){
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome")
	public Optional<Cozinha> cosinhaPorNome(String nome){
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/cozinhas/exists-por-nome")
	public boolean existsPorNome(String nome){
		return cozinhaRepository.existsByNome(nome);
	}
	
	@GetMapping("/cozinhas/primeira")
	public Optional<Cozinha> cozinhaPrimeiro(){
		return cozinhaRepository.buscarPrimeiro();
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantePorTaxaFrete(
			BigDecimal taxaInicial, BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurantes/por-nome-frete")
	public List<Restaurante> restaurantePorNomeFrete(String nome,
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
		
	@GetMapping("/restaurantes/por-nome-cozinha")
	public List<Restaurante> restaurantePorNome(String nome, Long cozinhaId){
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantePrimeiroPornome(String nome){
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/top-2-por-nome")
	public List<Restaurante> restauranteTop2Pornome(String nome){
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/count-por-cozinha")
	public int countPorCozinha(Long cozinhaId){
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restauranteComFreteGratis(String nome){
		
		return restauranteRepository.findComFreteGratis(nome);
	}
	
	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> RestaurantePrimeiro(){
		
		return restauranteRepository.buscarPrimeiro();
	}
	
}
