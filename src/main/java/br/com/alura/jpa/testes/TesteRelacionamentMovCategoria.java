package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentMovCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
	
		
		Categoria cat = new Categoria("Viagens");
		Categoria cat2 = new Categoria("Negocios");
		
		Conta conta = em.find(Conta.class,2l);
		
		
		Movimentacao  mov = new Movimentacao();
		mov.setDescricao("Viagem a Sp");
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov.setData(LocalDateTime.now());
		mov.setValor(new BigDecimal(300.0));
		
		
		mov.setCategorias(Arrays.asList(cat,cat2));
		mov.setConta(conta);
		
		Movimentacao  mov2 = new Movimentacao();
		mov2.setDescricao("Viagem a Rio ");
		mov2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov2.setData(LocalDateTime.now().plusDays(1));
		mov2.setValor(new BigDecimal(400.0));
		mov.setCategorias(Arrays.asList(cat,cat2));
		mov2.setConta(conta);
		
	
		
		em.getTransaction().begin();
		
		//transformando transition em manager
		em.persist(cat);
		em.persist(mov2);
		em.persist(mov);
		em.persist(mov2);
		//fechando a transaçao
		em.getTransaction().commit();
		em.close();
		

	}
}


