package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteCriaConta {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();
		
		conta.setAgencia(280);
		conta.setConta(7774);
		conta.setTitular("Caio Abreu");
		
		entityManager.getTransaction().begin(); //Necessário instanciar essa transaçao, como se fosse um buffer
		
		entityManager.persist(conta);
		
		entityManager.getTransaction().commit(); //Fechando a transação
	}

}
