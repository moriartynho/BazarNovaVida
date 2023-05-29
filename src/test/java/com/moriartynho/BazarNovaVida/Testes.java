package com.moriartynho.BazarNovaVida;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

@DataJpaTest
@SpringBootTest
public class Testes {
	
	@Autowired
	private UsuarioService usuarioService;

	@Test
	@BeforeAll
	public void usuarioDeTeste() {
		Usuario usuario = new Usuario();
		usuario.setNomeDoUsuario("Wilkson Junior de Souza");
		usuario.setCpf("08364194569");
		usuario.setSenha("cicada3301");
		usuarioService.insert(usuario);
	}

}
