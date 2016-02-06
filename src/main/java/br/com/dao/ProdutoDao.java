package br.com.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.entities.Produto;
import br.com.infra.SessionCreator;

@RequestScoped

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
	public List<Produto> listaTudo() {
		List<Produto> prodList = session.createCriteria(Produto.class).list();
		return prodList;
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
