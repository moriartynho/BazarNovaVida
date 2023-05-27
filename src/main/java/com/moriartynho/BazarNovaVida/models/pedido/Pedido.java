package com.moriartynho.BazarNovaVida.models.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	private List<Item> itens = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDoPedido;

	@Enumerated(EnumType.STRING)
	private EstadoDoPedido estadoDoPedido = EstadoDoPedido.EM_ANDAMENTO;

	public EstadoDoPedido getEstadoDoPedido() {
		return estadoDoPedido;
	}

	public void setEstadoDoPedido(EstadoDoPedido estadoDoPedido) {
		this.estadoDoPedido = estadoDoPedido;
	}

	public Pedido() {
	}

	public Pedido(List<Item> itens, Usuario usuario, LocalDate dataDoPedido) {
		this.itens = itens;
		this.usuario = usuario;
		this.dataDoPedido = dataDoPedido;
	}

	public BigDecimal getValorDoPedido() {
		return itens.stream().map(Item::getValorDoItem).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public String getId() {
		String id = String.format("%04d", this.id);
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(LocalDate dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

}
