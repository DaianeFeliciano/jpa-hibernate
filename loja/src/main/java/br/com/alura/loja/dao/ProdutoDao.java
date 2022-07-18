package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto); // retorna para estado gerenciado
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, 1L);
	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}
	/*
	 * A JPA entender� que a�categoria�� um atributo da classe produto e, neste
	 * caso, um relacionamento. Ent�o, ele quer filtrar por um atributo dentro do
	 * relacionamento, desta maneira, a JPA automaticamente gerar� um�join, isto �,
	 * ela j� sabe que deve filtrar pelo relacionamento e faz
	 * o�join�automaticamente, evitando que seja necess�rio fazer manualmente, como
	 * seria no SQL.
	 * 
	 */
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
	    String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
	        return em.createQuery(jpql, BigDecimal.class)
	                    .setParameter("nome", nome)
	                    .getSingleResult(); //serve para carregar uma �nica entidade ou um �nico registro que vir� na consulta,
	    }
	
}
