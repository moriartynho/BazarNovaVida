package com.moriartynho.BazarNovaVida.services.login;

import org.springframework.validation.BindingResult;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

public class LoginInvalido extends EfetuarLogin {

	public LoginInvalido() {
		super(null);
	}

	@Override
	protected String efetuar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		result.rejectValue("cpf", "error.usuario", "CPF ou senha inválidos");
		return "redirect:/login/formulario";
	}

	@Override
	protected boolean verificar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		return true;
	}

}
