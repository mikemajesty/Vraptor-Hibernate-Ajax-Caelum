package br.com.controller;


import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.Action;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.dao.ProdutoDao;
import br.com.entities.Produto;

@Controller
public class ProdutoController {

	private Result result;
	private ProdutoDao produtoDao;

	protected ProdutoController() {
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao produtoDao) {

		this.result = result;
		this.produtoDao = produtoDao;

		/*Produto produto = getProduto();

		produtoDao.salvar(produto);

		Produto prod = produtoDao.getProdutoBiID(1);
		prod.setNome("Malha de cota");
		produtoDao.alterar(prod);

		produtoDao.delete(prod.getProdutoID());*/

	}

	private Produto getProduto() {
		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}

	@Path("/olamundo")
	public Produto olaMundo() {
		Produto produto = new Produto();
		result.include("olaMundo", "Olá Mundo");
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}

	@Path("/listar")
	public void listar() {
		result.include("produtos", produtoDao.listaTudo());
	}

	@Path("/")
	public void index() {
		result.include("variable", "Bem vindo ao Curso da Caelum!");
	}

	@Path("/novo")
	@Get
	public void cadastrar() {

	}

	@Path("/novo")
	@Post
	public void cadastrar(Produto produto) {
		produtoDao.salvar(produto);
		result.redirectTo(this).listar();
	}
	@Path("/editar")
	@Get
	public Produto editar(int id){
		return produtoDao.getProdutoBiID(id);
		
	}
	@Path("/editar")
	@Post
	public void editar(Produto produto){
		produtoDao.alterar(produto);
		result.redirectTo(this).listar();
	}
	@Path("/deletar")
	@Get
	public Produto deletar(int id){
		return produtoDao.getProdutoBiID(id);
		
	}
	@Path("/confirmar")
	@Post
	public void confirmar(int id){
		produtoDao.delete(produtoDao.getProdutoBiID(id).getProdutoID());
		result.redirectTo(this).listar();
		
	}
	@Path("/detalhes")
	@Get
	public Produto detalhes(int id){
		return produtoDao.getProdutoBiID(id);
	}
}
