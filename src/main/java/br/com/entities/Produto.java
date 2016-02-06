package br.com.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private int produtoID;
	
	public int getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(int produtoID) {
		this.produtoID = produtoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String nome;
}
