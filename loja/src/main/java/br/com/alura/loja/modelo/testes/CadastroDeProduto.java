package br.com.alura.loja.modelo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi");
		celular.setDescricao("Legal");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin(); //inicia a transação
		em.persist(celular);
		em.getTransaction().commit(); 
		em.close(); // finalizar com em.close() para que o recurso não fique aberto
	}
}
