package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlterandoSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta contaElaonardo = em.find(Conta.class, 1l);
		
		em.getTransaction().begin();
		
		contaElaonardo.setSaldo(20.0);
		
		em.getTransaction().commit();
		
		
		
		

	}

}
