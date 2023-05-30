package com.moriartynho.BazarNovaVida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.pedido.EstadoDoPedido;
import com.moriartynho.BazarNovaVida.models.pedido.Pedido;
import com.moriartynho.BazarNovaVida.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findByUsuarioId(Long id) {
		return pedidoRepository.findByUsuarioId(id);
	}
	
	public void insert(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public Pedido findById(Long id) {
		return pedidoRepository.findById(id).get();
	}

	public void cancelarPedido(Pedido pedido) {
		pedido.getItens().forEach(i -> i.setEstadoDoItem(EstadoDoItem.DISPONIVEL));
		pedido.setEstadoDoPedido(EstadoDoPedido.CANCELADO);
		pedidoRepository.save(pedido);
	}


}
