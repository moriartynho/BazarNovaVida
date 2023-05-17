package com.moriartynho.BazarNovaVida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByEstadoDoItem(EstadoDoItem disponivel);
	Item getItemById(Long id);

}
