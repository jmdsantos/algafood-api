package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class InclusaoFormaPagamentoMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento1 = new FormaPagamento(); 
		formaPagamento1.setDescricao("Boleto");
		
		FormaPagamento formaPagamento2 = new FormaPagamento(); 
		formaPagamento2.setDescricao("Transferência - TED");
		
		formaPagamento1 = formaPagamentos.salvar(formaPagamento1);
		formaPagamento2 = formaPagamentos.salvar(formaPagamento2);
		
		System.out.printf("Forma de Pagamento: %s \n", formaPagamento1.getDescricao());
		System.out.printf("Forma de Pagamento: %s \n", formaPagamento2.getDescricao());
		
	}
}
