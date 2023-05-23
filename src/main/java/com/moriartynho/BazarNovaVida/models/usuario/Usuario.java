package com.moriartynho.BazarNovaVida.models.usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moriartynho.BazarNovaVida.models.Carrinho;
import com.moriartynho.BazarNovaVida.models.pedido.Pedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nomeDoUsuario;

	@Column(unique = true)
	@CPF
	private String cpf;

	@NotBlank
	@Length(min = 6)
	private String senha;

	@Enumerated(EnumType.STRING)
	private TipoDeUsuario tipoDeUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<>();
	
	@Transient
	private Carrinho carrinho;

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}

	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

}
