package com.moriartynho.BazarNovaVida.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moriartynho.BazarNovaVida.models.itens.EstadoDoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.services.ItemService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ItemService itemService;

	@GetMapping()
	public String home(Model model, HttpSession session) {
		List<Item> itens = itemService.findByEstadoDoItem(EstadoDoItem.DISPONIVEL);
		model.addAttribute("itens", itens);
		return "home";
	}

}
