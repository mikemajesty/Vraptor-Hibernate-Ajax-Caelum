package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.config.ApplicationConfiguration;
import br.com.entities.Produto;

@Controller
public class IndexController {

	private final Result result;
	SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();

	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		
		session.beginTransaction();
		this.result = result;

		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		
		session.save(produto);
		
		session.getTransaction().commit();

		session.close();
		
		alterarProduto();
		removeProduto();
	}
    private void alterarProduto(){
    	
    	Session session = factory.openSession();
    	
    	
    	Produto produto = (Produto) session.load(Produto.class, 1);
    
    	Transaction tx = session.beginTransaction();
    	produto.setPreco(42.50);
    	session.update(produto);
    	tx.commit();
    }
    private void removeProduto(){
    	
    	Session session = factory.openSession();
    	
    	Produto produto = (Produto) session.load(Produto.class, 1);
    
    	Transaction tx = session.beginTransaction();
    	session.delete(produto);
    	tx.commit();
    }
    @Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}
}