package com.moriartynho.BazarNovaVida.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.models.itens.imagem.Imagem;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.repositories.ItemRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ImagemService imagemService;
	
	public List<Item> findByEstadoDoItem(EstadoDoItem disponivel) {
		List<Item> itens = itemRepository.findByEstadoDoItem(disponivel);
		return itens;
	}
	
	@Cacheable
	public Item findById(Long id) {
		return itemRepository.findById(id).get();
	}

	public void insert(Item item, Imagem imagem) throws IOException {
		imagemService.salvarImagem(imagem);
		itemRepository.save(item);
	}

	public void adicionarAoCarrinho(Usuario usuario, Long id) {
		Item item = findById(id);
		if (item.getEstadoDoItem() == EstadoDoItem.DISPONIVEL) {
			usuario.getCarrinho().add(item);
			item.setEstadoDoItem(EstadoDoItem.INDISPONIVEL);
			itemRepository.save(item);
		}

	}

	public void removerDoCarrinho(Usuario usuario, Integer index, HttpSession session) {
		Item item = findById(usuario.getCarrinho().get(index).getId());
		item.setEstadoDoItem(EstadoDoItem.DISPONIVEL);
		usuario.getCarrinho().remove(index.intValue());
		session.setAttribute("usuarioLogado", usuario);
		itemRepository.save(item);
	}

}
