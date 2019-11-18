package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class InclusaoCidadeMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		
		
		Cidade cidade1 = new Cidade(); 
		cidade1.setNome("São Paulo");		
		cidade1.setEstado(estados.buscar(3L));
		
		Cidade cidade2 = new Cidade(); 
		cidade2.setNome("Rio de Janeiro");
		cidade2.setEstado(estados.buscar(4L));
		
		Cidade cidade3 = new Cidade(); 
		cidade3.setNome("Parana");
		cidade3.setEstado(estados.buscar(5L));
		
		cidade1 = cidades.salvar(cidade1);
		cidade2 = cidades.salvar(cidade2);
		cidade3 = cidades.salvar(cidade3);
		
		System.out.printf("%d - %s-%s\n", cidade1.getId(), cidade1.getNome(), cidade1.getEstado().getUF());
		System.out.printf("%d - %s-%s\n", cidade2.getId(), cidade2.getNome(), cidade2.getEstado().getUF());
		System.out.printf("%d - %s-%s\n", cidade3.getId(), cidade3.getNome(), cidade3.getEstado().getUF());
		
	}
}
