package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaClienteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(20);
		
		Cliente cliente = new Cliente();
		cliente.setEndereço("Av. Oscar Niemeyer, 400 - São Paulo, São Paulo");
		cliente.setNome("Pablo Vitar");
		cliente.setProfissao("Drag Queen");
		cliente.setConta(conta);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entManager = entityManagerFactory.createEntityManager();
		
		entManager.getTransaction().begin();
		
		entManager.persist(cliente);
		
		entManager.getTransaction().commit();
		entManager.close();
		
		/*OBSERVAÇÃO IMPORTANTÍSSIMA 
		 * 
		 * Por ser uma relacionamento OneToOne temos que acrescentar a constraint antes da criação
		 * da tabela, como isso não foi feito teria que apagar o banco de dados e realizar os
		 * cadastros novamente. Como já tem muita informação não irei apagar o banco de dados, sendo
		 * assim, o banco está adicionando mais de um cliente para a mesma conta.
		 * 
		 * */
	}

}
