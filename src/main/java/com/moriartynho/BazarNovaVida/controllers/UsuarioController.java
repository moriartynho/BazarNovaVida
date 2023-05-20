package com.moriartynho.BazarNovaVida.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moriartynho.BazarNovaVida.dto.NovoUsuario;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("formulario")
	public String formulario(NovoUsuario novoUsuario) {
		return "usuario/novoUsuarioForm";
	}

	@PostMapping("novo")
	public String novo(@Valid NovoUsuario novoUsuario, BindingResult result) {
		Usuario usuario = novoUsuario.toUsuario();

		if (result.hasErrors()) {
			return "usuario/novoUsuarioForm";
		}

		if (!usuarioService.cpfExiste(novoUsuario.getCpf())) {
			usuarioService.insert(usuario);
			return "redirect:/";
		} else
			result.rejectValue("cpf", "error.usuario", "CPF já cadastrado");
			return "usuario/novoUsuarioForm";

	}

	@PostMapping("login")
	public String login(Usuario usuario, BindingResult result, HttpSession session) throws NoSuchAlgorithmException {

		return null;

	}

}
