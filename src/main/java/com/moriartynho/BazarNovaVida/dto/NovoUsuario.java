package com.moriartynho.BazarNovaVida.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.moriartynho.BazarNovaVida.models.usuario.TipoDeUsuario;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NovoUsuario {

	@Column(unique = true)
	@CPF
	@NotBlank
	private String cpf;
	
	@NotBlank
	@NotNull
	private String nomeDoUSuario;
	
	@NotBlank
	@Length(min = 6, max=15)
	private String senha;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeDoUSuario() {
		return nomeDoUSuario;
	}

	public void setNomeDoUSuario(String nomeDoUSuario) {
		this.nomeDoUSuario = nomeDoUSuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNomeDoUsuario(nomeDoUSuario);
		usuario.setSenha(senha);
		usuario.setCpf(cpf);
		usuario.setTipoDeUsuario(TipoDeUsuario.COMUM);
		return usuario;
	}

}
