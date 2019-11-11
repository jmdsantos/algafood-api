package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante(); 
		restaurante1.setNome("Restaurante 1");
		restaurante1.setTaxaFrete(new BigDecimal("6.50"));
		
		Restaurante restaurante2 = new Restaurante(); 
		restaurante2.setNome("Restaurante 2");
		restaurante2.setTaxaFrete(new BigDecimal("8.50"));
		
		restaurante1 = restaurantes.salvar(restaurante1);
		restaurante2 = restaurantes.salvar(restaurante2);
		
		System.out.printf("Restaurante %s - Taxa frete: %.2f\n", restaurante1.getNome(), restaurante1.getTaxaFrete());
		System.out.printf("Restaurante %s - Taxa frete: %.2f\n", restaurante2.getNome(), restaurante2.getTaxaFrete());
		
	}
}
