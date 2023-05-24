package com.moriartynho.BazarNovaVida.services.login;

import org.springframework.validation.BindingResult;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

public abstract class EfetuarLogin {

	protected EfetuarLogin proxima;

	public EfetuarLogin(EfetuarLogin proxima) {
		this.proxima = proxima;
	}

	public String efetuaLogin(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		if (verificar(loginDto, result, session, service)) {
			return efetuar(loginDto, result, session, service);
		} else
			return proxima.efetuar(loginDto, result, session, service);
	}

	protected abstract String efetuar(LoginDTO loginDto, BindingResult result, HttpSession session,
			UsuarioService service);

	protected abstract boolean verificar(LoginDTO loginDto, BindingResult result, HttpSession session,
			UsuarioService service);

}
