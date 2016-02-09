package br.com.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.entities.Imagens;
import br.com.entities.Produto;

public class ImagensController {

	private Validator validator;
    private Result result;
    private Imagens imagens;
	protected ImagensController() {

	}

	@Inject
	public ImagensController(Validator validator,Result result,Imagens imagens) {
		this.validator = validator;
		this.result = result;
		this.imagens = imagens;
	}

	@Post("/produtos/{produto.id}/imagem")
	public void upload(Produto produto, UploadedFile imagem) {
		validator.addIf(imagem.equals("") || imagem.equals(null),
				new SimpleMessage("imagen", "imagem nula"));
		validator.onErrorRedirectTo(ProdutoController.class).editar(
				produto.getProdutoID());
		
		imagens.salva(imagem, produto);
		result.redirectTo(ProdutoController.class)
		.editar(produto.getProdutoID());
		
	}
}
