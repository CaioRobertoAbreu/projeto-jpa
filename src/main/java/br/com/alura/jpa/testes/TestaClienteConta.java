package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaClienteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		Cliente cliente = new Cliente();
		cliente.setEndereco("Av. Oscar Niemeyer, 400 - Sao Paulo, Sao Paulo");
		cliente.setNome("Pablo Vitar");
		cliente.setProfissao("Drag Queen");
		cliente.setConta(conta);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entManager = entityManagerFactory.createEntityManager();
		
		entManager.getTransaction().begin();
		
		entManager.persist(cliente);
		
		entManager.getTransaction().commit();
		entManager.close();
		
		/*OBSERVAcaO IMPORTANTiSSIMA 
		 * 
		 * Por ser uma relacionamento OneToOne temos que acrescentar a constraint antes da criacao
		 * da tabela, como isso nao foi feito teria que apagar o banco de dados e realizar os
		 * cadastros novamente. Como ja tem muita informacao nao irei apagar o banco de dados, sendo
		 * assim, o banco esta adicionando mais de um cliente para a mesma conta.
		 * 
		 * */
	}

}
