package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLOrderBy2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String queryJPQL = "select m from Movimentacao m order by m.valor desc";
		
		TypedQuery<Movimentacao> query = em.createQuery(queryJPQL, Movimentacao.class);
		
		List<Movimentacao> resultList = query.getResultList();
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Valor: " + movimentacao.getValor() + " - " + movimentacao.getDescricao());
		}
	}
}
