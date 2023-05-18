package com.moriartynho.BazarNovaVida.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.repositories.ItemRepository;

@Controller
public class HomeController {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/")
	public String home(Model model) {
		List<Item> itens = itemRepository.findByEstadoDoItem(EstadoDoItem.DISPONIVEL);
		model.addAttribute("itens", itens);
		return "home";
	}

}
