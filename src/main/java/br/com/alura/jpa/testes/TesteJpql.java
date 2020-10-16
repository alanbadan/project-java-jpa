package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJpql {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		
		String sql = "select m from Movimentacao m where m.conta= :pConta order by m.valor desc";
		

		Conta conta = new Conta();
		conta.setId(1l);
		
	   TypedQuery<Movimentacao> query = em.createQuery(sql,Movimentacao.class);
		query.setParameter("pConta", conta);
		
		
		
		List<Movimentacao> resultList = query.getResultList();
		for (Movimentacao movimentacao  : resultList) {
			
			System.out.println("descriçaõ :" + movimentacao.getDescricao());
			System.out.println("tipo :" + movimentacao.getTipoMovimentacao());
		
		}
		
	
	}

}
