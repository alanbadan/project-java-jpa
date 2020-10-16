package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {


       EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
       EntityManager em = emf.createEntityManager();
       
       
       Movimentacao mov = em.find(Movimentacao.class, 1l);
       Conta conta = mov.getConta();
       int QuantidadeMovimentacao = conta.getMovimentacao().size();
		
		
		System.out.println("Quantidade de movimentaçoes :" + QuantidadeMovimentacao);
		System.out.println("Titula da conta : " + conta.getTitular());
		
		
	}

}
