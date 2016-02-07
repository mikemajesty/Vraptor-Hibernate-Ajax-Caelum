package br.com.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.entities.Produto;
import br.com.infra.SessionCreator;


public class ProdutoDao {

	private Session session;

	protected ProdutoDao() {
		
	}
	@Inject
	public ProdutoDao(SessionCreator sessionCreator){
		session = sessionCreator.getSession();
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
