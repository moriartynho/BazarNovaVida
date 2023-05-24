package com.moriartynho.BazarNovaVida.services.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

public class LoginCpfNaoExiste extends EfetuarLogin {
	
	@Autowired
	protected UsuarioService usuarioService;

	public LoginCpfNaoExiste(EfetuarLogin proxima) {
		super(proxima);
	}
	
	@Override
	protected String efetuar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		result.rejectValue("cpf", "error.usuario", "CPF não existe");
		return "redirect:/login/formulario";
	}
	
	@Override
	protected boolean verificar(LoginDTO loginDto, BindingResult result, HttpSession session, UsuarioService service) {
		return !service.cpfExiste(loginDto.getCpf());
	}

}
