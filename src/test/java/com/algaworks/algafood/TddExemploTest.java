package com.algaworks.algafood;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.model.Cidade;
import com.modelo.service.Operacao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TddExemploTest {

	private int valor = 1;
	
	@Test
	public void ValidaValordaOperacaoTest(){
		
		int novoValor = 1;
		
		Assertions.assertThat(novoValor).isEqualTo(valor);
		
	}
	
	@Test
	public void ValidaSeDadoNull(){
		
		Cidade cidade = new Cidade();
		cidade.setId((long) 1);
		Assertions.assertThat(cidade.getId()).isNotNull();
		
	}
	
	@Test
	public void ValidaPu(){		
		Operacao operacao = new Operacao(100, 1.45454);		
		Assertions.assertThat(operacao.getPu()).isEqualTo(1.45454);
		
	}
	
	@Test
	public void ValidaQtd(){		
		Operacao operacao = new Operacao(100, 1.45454);		
		Assertions.assertThat(operacao.getQtd()).isEqualTo(100);
		
	}
	
	@Test
	public void ValidaCalculo(){		
		
		double financeiro = 100.00;
		
		Operacao operacao = new Operacao(100, 1.45454);		
		Assertions.assertThat(operacao.getValorFinanceiro()).isGreaterThanOrEqualTo(financeiro);
		
	}
	
}
