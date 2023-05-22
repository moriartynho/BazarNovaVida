package com.moriartynho.BazarNovaVida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.models.pedido.Pedido;
import com.moriartynho.BazarNovaVida.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findByUsuarioId(Long id) {
		return pedidoRepository.findByUsuarioId(id);
	}
	
	public void adicionarAoCarrinho(Item item) {
		
	}

}
