package com.moriartynho.BazarNovaVida.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moriartynho.BazarNovaVida.dto.LoginDTO;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.repositories.UsuarioRepository;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("formulario")
	public String formulario() {
		return "usuario/login";
	}

	@PostMapping("efetua")
	public String login(@ModelAttribute LoginDTO loginDto, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			System.out.println("erro");
			return "redirect:/login/formulario";

		}

		if (!usuarioService.cpfExiste(loginDto.getCpf())) {
			result.rejectValue("cpf", "error.usuario", "CPF não existe");
			System.out.println("cpf não existe");
			return "redirect:/login/formulario";
		}

		Usuario usuario = repository.findByCpf(loginDto.getCpf());

		if (usuario.getSenha().equals(loginDto.getSenha()) && usuario.getCpf().equals(loginDto.getCpf())) {
			session.setAttribute("usuarioLogado", usuario);
			System.out.println(session.getAttribute("usuarioLogado"));
			System.out.println("sucesso");
			return "redirect:/";
		} else {
			result.rejectValue("cpf", "error.usuario", "CPF ou senha inválidos");
			System.out.println("inválido");
			return "redirect:/login/formulario";
		}

	}
}
