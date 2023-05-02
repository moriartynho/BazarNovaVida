package com.moriartynho.BazarNovaVida.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moriartynho.BazarNovaVida.dto.NovoUsuario;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("formulario")
	public String formulario(NovoUsuario novoUsuario) {
		return "usuario/novoUsuarioForm";
	}
	
	
	@PostMapping("novo")
	public String novo(@Valid NovoUsuario novoUsuario, BindingResult result) {
		if (result.hasErrors()) {
			return "usuario/novoUsuarioForm";
		}

		Usuario usuario = novoUsuario.toUsuario();
		usuarioRepository.save(usuario);

		return "redirect:/home";
	}
	
}
