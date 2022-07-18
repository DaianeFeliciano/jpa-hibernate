package br.com.alura.loja.modelo.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto celular = new Produto("Xiaomi", "Legal", new BigDecimal("800"), Categoria.CELULARES);
		celular.setNome("Xiaomi");
		celular.setDescricao("Legal");
		celular.setPreco(new BigDecimal("800"));

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao dao = new ProdutoDao(em);

		em.getTransaction().begin(); // inicia a transa��o
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close(); // finalizar com em.close() para que o recurso n�o fique aberto
	}
}
