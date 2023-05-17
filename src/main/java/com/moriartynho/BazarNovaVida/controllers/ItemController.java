package com.moriartynho.BazarNovaVida.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moriartynho.BazarNovaVida.dto.NovoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.repositories.ItemRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("formulario")
	public String formulario(NovoItem novoItem) {
		return "item/novoItemForm";
	}

	@GetMapping("selecionar")
	public String itemPorId(@RequestParam("id") Long id, Model model) {
		Item item = itemRepository.getItemById(id);
		model.addAttribute("item", item);
		return "item/itemSelecionado";
	}

	@PostMapping("novo")
	public String novo(@Valid NovoItem novoItem, BindingResult result) {
		if (result.hasErrors()) {
			return "item/novoItemForm";
		}

		Item item = novoItem.toItem();
		itemRepository.save(item);

		return "redirect:/home";

	}
}
