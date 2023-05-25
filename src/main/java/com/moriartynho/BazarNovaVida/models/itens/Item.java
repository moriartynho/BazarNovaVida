package com.moriartynho.BazarNovaVida.models.itens;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.moriartynho.BazarNovaVida.models.itens.imagem.Imagem;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Length(min = 5)
	private String nomeDoItem;

	@NotNull
	private BigDecimal valorDoItem;

	@NotBlank
	private String descricaoDoItem;

	@NotBlank
	private String imgUrl;
	
	@NotNull
	@OneToOne
	private Imagem imagem;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Enumerated(EnumType.STRING)
	private EstadoDoItem estadoDoItem;

	public Integer getId() {
		return id;
	}

	public String getDescricaoDoItem() {
		return descricaoDoItem;
	}

	public void setDescricaoDoItem(String descricaoDoItem) {
		this.descricaoDoItem = descricaoDoItem;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDoItem() {
		return nomeDoItem;
	}

	public BigDecimal getValorDoItem() {
		return valorDoItem;
	}

	public void setValorDoItem(BigDecimal valorDoItem) {
		this.valorDoItem = valorDoItem;
	}

	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}

	public EstadoDoItem getEstadoDoItem() {
		return estadoDoItem;
	}

	public void setEstadoDoItem(EstadoDoItem estadoDoItem) {
		this.estadoDoItem = estadoDoItem;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nomeDoItem=" + nomeDoItem + ", valorDoItem=" + valorDoItem + ", descricaoDoItem="
				+ descricaoDoItem + ", imgUrl=" + imgUrl + ", estadoDoItem=" + estadoDoItem + "]";
	}

}
