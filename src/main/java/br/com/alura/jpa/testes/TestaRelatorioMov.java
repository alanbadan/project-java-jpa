package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioMov {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		
		String jpql = "select c from Conta c join left fetch c.movimentacao";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

		
		List<Conta> contas = query.getResultList();
		for (Conta conta : contas) {
			System.out.println("Titular :" + conta.getTitular());
			System.out.println("Agencia :" + conta.getAgencia());
			System.out.println("Numero :" + conta.getNumero());
			System.out.println("Movimentação :" + conta.getMovimentacao());

		}

	}

}
