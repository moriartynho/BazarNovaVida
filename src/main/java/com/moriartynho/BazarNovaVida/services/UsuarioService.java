package com.moriartynho.BazarNovaVida.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void insert(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public boolean cpfExiste(String cpf) {
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		return usuario != null;
	}

}
