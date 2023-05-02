package com.moriartynho.BazarNovaVida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.BazarNovaVida.models.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
