package br.com.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.dao.ProdutoDao;
import br.com.entities.Carrinho;
import br.com.entities.Item;

@Controller
@Path("/car")
public class CarrinhoController {

	protected CarrinhoController() {
	}

	private Carrinho carrinho;
	private ProdutoDao produtoDao;
	private Result result;

	@Inject
	public CarrinhoController(Carrinho carrinho, ProdutoDao produtoDao,
			Result result) {
		this.carrinho = carrinho;
		this.produtoDao = produtoDao;
		this.result = result;
	}

	@Post("/carrinho")
	public void adiciona(Item item) {
		produtoDao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(this).visualiza();
	}

	@Get("/visualiza")
	public void visualiza() {
	}

	@Delete("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}
}
