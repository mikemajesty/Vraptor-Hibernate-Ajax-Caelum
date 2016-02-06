package br.com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.entities.Produto;
import br.com.infra.SessionCreator;

public class ProdutoDao {

	private final Session session;

	public ProdutoDao() {
		this.session = SessionCreator.getSession();
	}

	public void salvar(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
		
	}

	public Produto getProdutoBiID(int id) {
		return (Produto) session.load(Produto.class, id);
	}

	public void alterar(Produto produto) {
		
		
		Transaction tx = session.beginTransaction();
		produto.setPreco(42.50);
		session.update(produto);
		tx.commit();
		
	}

	public void delete(int id) {
		Produto produto = getProdutoBiID(id);

		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
		
	}
}
