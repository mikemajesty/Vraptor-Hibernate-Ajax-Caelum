package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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


	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		this.result = result;
		
		Produto produto = new Produto();
		produto.setNome("Coca Cola");
		session.save(produto);
		
		session.getTransaction().commit();

		session.close();
	}

	@Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}
}