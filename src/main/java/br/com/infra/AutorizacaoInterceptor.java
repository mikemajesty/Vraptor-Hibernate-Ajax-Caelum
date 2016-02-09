package br.com.infra;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.controller.ProdutoController.Restrito;
//import br.com.controller.ProdutoController.Restrito;
import br.com.controller.UsuarioController;
import br.com.entities.UsuarioWeb;

public class AutorizacaoInterceptor implements Interceptor {

	private UsuarioWeb usuarioWeb;
	private Result result;

	protected AutorizacaoInterceptor() {
	}

	@Inject
	public AutorizacaoInterceptor(UsuarioWeb usuarioWeb, Result result) {
		this.usuarioWeb = usuarioWeb;
		this.result = result;
	}

	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method,
			Object controllerInstance) throws InterceptionException {
		result.redirectTo(UsuarioController.class).loginForm();

	}

	@Override
	public boolean accepts(ControllerMethod method) {
		return !usuarioWeb.isLogado() && method.containsAnnotation(Restrito.class);
	}

}
