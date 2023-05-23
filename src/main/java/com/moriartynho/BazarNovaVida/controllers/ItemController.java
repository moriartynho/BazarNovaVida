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
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.services.ItemService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("formulario")
	public String formulario(NovoItem novo) {
		return "item/novoItemForm";
	}

	@GetMapping("/selecionar")
	public String itemPorId(@RequestParam Long id, Model model) {
		Item item = itemService.findById(id);
		model.addAttribute("item", item);
		return "item/itemSelecionado";
	}

	@PostMapping("novo")
	public String novo(@Valid NovoItem novoItem, BindingResult result) {
		if (result.hasErrors()) {
			return "item/novoItemForm";
		}

		Item item = novoItem.toItem();
		itemService.insert(item);

		return "redirect:/";

	}

	@GetMapping("/adicionar")
	public String adicionarAoCarrinho(@RequestParam Long id, HttpSession session) {
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login/formulario";
		}
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		itemService.adicionarAoCarrinho(usuario, id);
		System.out.println(usuario.getNomeDoUsuario());
		usuario.getCarrinho().forEach(System.out::println);
		session.setAttribute("carrinho", usuario.getCarrinho());
		return "redirect:/";
	}
}
