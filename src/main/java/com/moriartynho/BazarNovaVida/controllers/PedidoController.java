package com.moriartynho.BazarNovaVida.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.models.pedido.Pedido;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.services.PedidoService;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("carrinho")
	public String carrinho() {
		return "pedido/carrinho";
	}

	@GetMapping("/finalizar")
	public String finalizar(HttpSession session) {
		List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
		Usuario usuario = usuarioService.usuarioLogado(session);
		LocalDate dataAtual = LocalDate.now();

		Pedido pedido = new Pedido(carrinho, usuario, dataAtual);
		pedidoService.insert(pedido);

		return "redirect:/";
	}

}
