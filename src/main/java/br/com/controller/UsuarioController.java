package br.com.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.dao.UsuarioDao;
import br.com.entities.Usuario;
import br.com.entities.UsuarioWeb;

@Controller
@Path("/usuario")
public class UsuarioController {

	private UsuarioDao dao;
	private Result result;
	private Validator validator;
	private UsuarioWeb usuarioWeb;

	protected UsuarioController() {
	}

	@Inject
	public UsuarioController(UsuarioDao dao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Path("/novo")
	public void novo() {

	}

	@Post("/usuarios")
	public void adiciona(Usuario usuario) {

		validator.addIf(dao.existeUsuario(usuario), new SimpleMessage(
				"usuario.login", "Login já existe"));

		validator.onErrorUsePageOf(UsuarioController.class).novo();
		dao.adiciona(usuario);
		result.redirectTo(ProdutoController.class).listar();
	}

	@Get("/login")
	public void loginForm() {
	}

	@Post("/login")
	public void loginForm(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);
		validator.addIf(carregado == null, new SimpleMessage("usuario.login",
				"Login e/ou senha inválidos"));
		validator.onErrorUsePageOf(UsuarioController.class).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(ProdutoController.class).listar();

	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutoController.class).listar();
	}
}
