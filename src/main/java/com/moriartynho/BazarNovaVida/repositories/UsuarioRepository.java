package com.moriartynho.BazarNovaVida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.BazarNovaVida.models.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
