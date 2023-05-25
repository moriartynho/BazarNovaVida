package com.moriartynho.BazarNovaVida.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.services.UsuarioService;
import com.moriartynho.BazarNovaVida.services.login.EfetuarLogin;
import com.moriartynho.BazarNovaVida.services.login.LoginCpfNaoExiste;
import com.moriartynho.BazarNovaVida.services.login.LoginInvalido;
import com.moriartynho.BazarNovaVida.services.login.LoginValido;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("formulario")
	public String formulario(HttpSession session) {
		if (usuarioService.usuarioLogado(session) == null) {
			return "usuario/login";
		}

		return "redirect:/";

	}

	@PostMapping("efetua")
	public String login(@ModelAttribute("loginDTO") LoginDTO loginDTO, BindingResult result, HttpSession session,
			Model model) {
		EfetuarLogin efetuarLogin = new LoginValido(new LoginCpfNaoExiste(new LoginInvalido()));
		return efetuarLogin.efetuaLogin(loginDTO, result, session, usuarioService);

	}
}
