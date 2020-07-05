package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Cliente;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select c from Cliente c where c.id= 4";
		
		Query query = em.createQuery(jpql);
		List<Cliente> listResult = query.getResultList();
		
		for (Cliente cliente : listResult) {
			System.out.println(cliente.getNome());
		}
		
	}

}
