package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLComParametro {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "Select m from Movimentacao m where m.conta = :pConta";
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> movimentacaoResult = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacaoResult) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Valor: " + movimentacao.getValor());
		}
		
		
	}

}
