package com.moriartynho.BazarNovaVida.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotNull;

public class LoginDTO {
	
	@CPF
	private String cpf;
	
	@NotNull
	private String senha;
	
	public LoginDTO() {
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
	
	

}
