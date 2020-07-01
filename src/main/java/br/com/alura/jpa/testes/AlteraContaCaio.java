package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraContaCaio {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta contaCaio =  entityManager.find(Conta.class, 2);
		
		entityManager.getTransaction().begin();
		contaCaio.setSaldo(450.0);
		entityManager.getTransaction().commit();
		
	}

}
