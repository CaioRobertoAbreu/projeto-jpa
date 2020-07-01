package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class EstadosJPA {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Estado Transient
		Conta conta = new Conta(4342, 52523, "Julia Lima", 565.90);
		
		entityManager.getTransaction().begin();
		
		//Estado Managed
		entityManager.persist(conta);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//Estado Datached
		conta.setSaldo(55.9);
		
		EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager2 = entityManagerFactory2.createEntityManager();
		
		entityManager2.getTransaction().begin();
		
		//Retornando para o estado Managed
		entityManager2.merge(conta);
		
//		===============================================================
//		REMOVENDO CONTAS
//		Ao remover a conta passa para o estado removed
		
		for (int i = 15; i < 19; i++) {
			conta = entityManager2.find(Conta.class, i); //-> Quando uso o find, automaticamente a conta vira managed
			entityManager2.remove(conta);
		}
		
		entityManager2.getTransaction().commit();
		
		
	}

}
