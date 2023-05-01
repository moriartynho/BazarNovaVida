package com.moriartynho.BazarNovaVida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moriartynho.BazarNovaVida.models.itens.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
