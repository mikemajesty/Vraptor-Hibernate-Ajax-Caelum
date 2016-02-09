package br.com.entities;

import javax.enterprise.context.SessionScoped;

public class UsuarioWeb {
	private Usuario logado;

	public void login(Usuario usuario) {
		this.logado = usuario;
	}

	public String getNome() {
		return logado.getNome();
	}

	public boolean isLogado() {
		return logado != null;
	}
	public void logout() {
		this.logado = null;
	}
}
