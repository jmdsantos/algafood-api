package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class InclusaoEstadoMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		Estado estado1 = new Estado(); 
		estado1.setNome("São Paulo");
		estado1.setUF("SP");
		
		Estado estado2 = new Estado(); 
		estado2.setNome("Rio de Janeiro");
		estado2.setUF("RJ");
		
		Estado estado3 = new Estado(); 
		estado3.setNome("Parana");
		estado3.setUF("PR");
		
		estado1 = estados.salvar(estado1);
		estado2 = estados.salvar(estado2);
		estado3 = estados.salvar(estado3);
		
		System.out.printf("%d - %s-%s\n", estado1.getId(), estado1.getNome(), estado1.getUF());
		System.out.printf("%d - %s-%s\n", estado2.getId(), estado2.getNome(), estado2.getUF());
		System.out.printf("%d - %s-%s\n", estado3.getId(), estado3.getNome(), estado3.getUF());
		
	}
}
