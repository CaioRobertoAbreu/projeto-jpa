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
		cliente.setEndere�o("Av. Oscar Niemeyer, 400 - S�o Paulo, S�o Paulo");
		cliente.setNome("Pablo Vitar");
		cliente.setProfissao("Drag Queen");
		cliente.setConta(conta);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entManager = entityManagerFactory.createEntityManager();
		
		entManager.getTransaction().begin();
		
		entManager.persist(cliente);
		
		entManager.getTransaction().commit();
		entManager.close();
		
		/*OBSERVA��O IMPORTANT�SSIMA 
		 * 
		 * Por ser uma relacionamento OneToOne temos que acrescentar a constraint antes da cria��o
		 * da tabela, como isso n�o foi feito teria que apagar o banco de dados e realizar os
		 * cadastros novamente. Como j� tem muita informa��o n�o irei apagar o banco de dados, sendo
		 * assim, o banco est� adicionando mais de um cliente para a mesma conta.
		 * 
		 * */
	}

}
