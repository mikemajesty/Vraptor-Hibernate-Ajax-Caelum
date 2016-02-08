package br.com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

public class Carrinho {

	private List<br.com.entities.Item> itens = new ArrayList<br.com.entities.Item>();

	public List<br.com.entities.Item> getItens() {
		return itens;
	}

	public void setItens(List<br.com.entities.Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	private Double total = 0.0;

	public void adiciona(Item item) {
		itens.add(item);
		total += item.getProduto().getPreco() * item.getQuantidade();
	}

	public Integer getTotalDeItens() {
		return itens.size();
	}

	public void remove(int indiceItem) {
		Item removido = itens.remove(indiceItem);
		total -= removido.getProduto().getPreco() * removido.getQuantidade();
	}
}
