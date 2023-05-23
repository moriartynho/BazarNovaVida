package com.moriartynho.BazarNovaVida.models;

import java.util.ArrayList;
import java.util.List;

import com.moriartynho.BazarNovaVida.models.itens.Item;

public class Carrinho {

	private List<Item> itens = new ArrayList<>();

	public Carrinho() {
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
