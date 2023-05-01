package com.moriartynho.BazarNovaVida.dto;

import java.math.BigDecimal;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NovoItem {

	@NotBlank
	private String nomeDoItem;

	@NotNull
	private BigDecimal valorDoItem;

	@NotBlank
	private String descricaoDoItem;
	

	public String getNomeDoItem() {
		return nomeDoItem;
	}

	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}

	public BigDecimal getValorDoItem() {
		return valorDoItem;
	}

	public void setValorDoItem(BigDecimal valorDoItem) {
		this.valorDoItem = valorDoItem;
	}

	public String getDescricaoDoItem() {
		return descricaoDoItem;
	}

	public void setDescricaoDoItem(String descricaoDoItem) {
		this.descricaoDoItem = descricaoDoItem;
	}

	public Item toItem() {
		Item item = new Item();
		item.setNomeDoItem(nomeDoItem);
		item.setValorDoItem(valorDoItem);
		item.setDescricaoDoItem(descricaoDoItem);
		item.setEstadoDoItem(EstadoDoItem.DISPONIVEL);
		return item;
	}

}
