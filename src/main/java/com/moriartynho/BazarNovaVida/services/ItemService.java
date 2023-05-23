package com.moriartynho.BazarNovaVida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findByEstadoDoItem(EstadoDoItem disponivel) {
		List<Item> itens = itemRepository.findByEstadoDoItem(disponivel);
		return itens;
	}

	public Item findById(Long id) {
		return itemRepository.findById(id).get();
	}

	public void insert(Item item) {
		itemRepository.save(item);
	}

	public void adicionarAoCarrinho(Usuario usuario, Long id) {
		Item item = this.findById(id);
		if(item.getEstadoDoItem()==EstadoDoItem.DISPONIVEL) {
			usuario.getCarrinho().add(item);
			//item.setEstadoDoItem(EstadoDoItem.INDISPONIVEL);
			itemRepository.save(item);
			return;
		}
		
	}

}
