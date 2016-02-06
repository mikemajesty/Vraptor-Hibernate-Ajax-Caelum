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
import br.com.dao.ProdutoDao;
import br.com.entities.Produto;
import br.com.infra.SessionCreator;

@Controller
public class IndexController {

	private final Result result;
	private ProdutoDao produtoDao;

	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		
		this.result = result;
		Produto produto = getProduto();
		
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.salvar(produto);
		
		Produto prod = produtoDao.getProdutoBiID(1);
		prod.setNome("Malha de cota");
		produtoDao.alterar(prod);
		
		produtoDao.delete(prod.getProdutoID());
		
	}
    private Produto getProduto() {
    	Produto produto =new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}

	@Path("/olamundo")
	public Produto olaMundo(){
		Produto produto =new Produto();
		result.include("olaMundo", "Olá Mundo");
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}
   
    @Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}
}
