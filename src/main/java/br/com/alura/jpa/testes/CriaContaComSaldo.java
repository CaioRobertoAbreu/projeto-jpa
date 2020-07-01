package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Estado Transient
		Conta conta = new Conta(7721, 75433, "Leoanardo Domingos", 1200.0);
		
		entityManager.getTransaction().begin();
		
		//Transient para Maneged
		entityManager.persist(conta);	
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		 //Ao invés de eu ter que abrir uma nova transação, para conseguir sincronizar 
		 //a conta, eu uso o atribuito merge, assim ele se torna maneged novamente.
		conta.setSaldo(1459.88);
		
		entityManager2.getTransaction().begin();
		entityManager2.merge(conta);
		entityManager2.getTransaction().commit();
		
	}

}
