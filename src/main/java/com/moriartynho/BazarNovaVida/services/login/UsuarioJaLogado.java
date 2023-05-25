package com.moriartynho.BazarNovaVida.services.login;

import org.springframework.validation.BindingResult;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

public class UsuarioJaLogado extends EfetuarLogin {

	public UsuarioJaLogado(EfetuarLogin proxima) {
		super(proxima);
	}

	@Override
	protected String efetuar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		return "redirect:/";
	}

	@Override
	protected boolean verificar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		return service.usuarioLogado(session) != null;
	}

}
