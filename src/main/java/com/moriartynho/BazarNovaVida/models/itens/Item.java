package com.moriartynho.BazarNovaVida.models.itens;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.moriartynho.BazarNovaVida.models.itens.imagem.Imagem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "imagem_id")
	private Imagem imagem;

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

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nomeDoItem=" + nomeDoItem + ", valorDoItem=" + valorDoItem + ", descricaoDoItem="
				+ descricaoDoItem + ", estadoDoItem=" + estadoDoItem + "]";
	}

}
