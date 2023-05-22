package com.moriartynho.BazarNovaVida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.BazarNovaVida.models.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByUsuarioId(Long id);

}
