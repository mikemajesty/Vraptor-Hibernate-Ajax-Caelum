package br.com.controller;

import java.util.List;

import javax.inject.Inject;


import com.google.gson.JsonElement;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.dao.ProdutoDao;
import br.com.entities.Produto;
import static br.com.caelum.vraptor.view.Results.*;

@Controller
public class ProdutoController {

	private Result result;
	private ProdutoDao produtoDao;
	private Validator validator;

	protected ProdutoController() {
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao produtoDao,
			Validator validator) {

		this.result = result;
		this.produtoDao = produtoDao;
		this.validator = validator;

	}

	private Produto getProduto() {
		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}

	@Get("/olamundo")
	public Produto olaMundo() {
		Produto produto = new Produto();
		result.include("olaMundo", "Olá Mundo");
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para colocar livros");
		produto.setPreco(35.90);
		return produto;
	}

	@Get("/listar")
	public void listar() {
		result.include("produtos", produtoDao.listaTudo());
	}

	@Get("/")
	public void index() {
		result.include("variable", "Bem vindo ao Curso da Caelum!");
	}

	@Get("/novo")
	public void cadastrar() {

	}

	@Post("/novo")
	public void cadastrar(Produto produto) {
		// Uma forma quando se usa dataannotation

		validator.validate(produto);

		// Uma outra forma para validar, sem dataannotation
		/*
		 * validator.addIf(produto.getNome() == null || produto.getNome() == ""
		 * , new SimpleMessage("nome", "Nome é requerido"));
		 * validator.addIf(produto.getPreco() == null || produto.getPreco() == 0
		 * ,new SimpleMessage("preco","Preço não pode ser maior que zero"));
		 * validator.addIf(produto.getDescricao() == "" ||
		 * produto.getDescricao() == null, new
		 * SimpleMessage("descricao","Descrição é requerido"));
		 */

		if (validator.hasErrors()) {
			validator.onErrorForwardTo(this).cadastrar();
		}
		produtoDao.salvar(produto);
		result.redirectTo(this).listar();
	}

	@Get("/editar-{id}")
	public Produto editar(int id) {
		return produtoDao.getProdutoBiID(id);

	}

	@Post("/editar")
	public void editar(Produto produto) {
		validator.validate(produto);
		validator.onErrorForwardTo(this).editar(produto.getProdutoID());
		produtoDao.alterar(produto);
		result.redirectTo(this).listar();
	}

	@Get("/deletar-{id}")
	public Produto deletar(int id) {
		return produtoDao.getProdutoBiID(id);

	}

	@Post("/confirmar")
	public void confirmar(int id) {
		produtoDao.delete(produtoDao.getProdutoBiID(id).getProdutoID());
		result.redirectTo(this).listar();

	}

	@Get("/detalhes-{id}")
	public Produto detalhes(int id) {
		return produtoDao.getProdutoBiID(id);
	}

	@Get("/busca")
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return produtoDao.findByName(nome);

	}

	@Get("/buscaJson")
	public void buscaJson(String nome) {
		result.use(json()).withoutRoot().from(produtoDao.findByName(nome))
				.exclude("produtoID", "descricao").serialize();
	}
}
