package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteMovimentacao {
	public static void main(String[] args) {
				
		Conta conta =  new Conta(3615, 53789, "Leonardo", 450.);
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(550.));
		movimentacao.setDescricao("Churrasqueiro");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
