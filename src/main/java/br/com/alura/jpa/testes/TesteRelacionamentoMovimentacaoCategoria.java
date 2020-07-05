package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(2);
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Viagem a Salvador");
		movimentacao.setConta(conta);
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(700.));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setDescricao("Viagem a Minas Gerais");
		movimentacao2.setConta(conta);
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal(500.));
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria);
		entityManager.persist(categoria2);
		entityManager.persist(movimentacao);
		entityManager.persist(movimentacao2);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
