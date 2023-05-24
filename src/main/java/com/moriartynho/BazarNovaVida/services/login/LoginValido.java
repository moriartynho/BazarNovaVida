package com.moriartynho.BazarNovaVida.services.login;

import org.springframework.validation.BindingResult;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

public class LoginValido extends EfetuarLogin {

	public LoginValido(EfetuarLogin proxima) {
		super(proxima);
	}

	@Override
	protected String efetuar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		Usuario usuario = service.findByCpf(loginDto.getCpf());
		session.setAttribute("usuarioLogado", usuario);
		return "redirect:/";
	}

	@Override
	protected boolean verificar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		Usuario usuario = service.findByCpf(loginDto.getCpf());
		return usuario.getSenha().equals(loginDto.getSenha()) && usuario.getCpf().equals(loginDto.getCpf());
	}

}
