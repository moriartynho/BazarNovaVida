package com.moriartynho.BazarNovaVida.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	public String carrinho(HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);
		if (usuario == null) {
			return "redirect:/login/formulario";
		}
		return "pedido/carrinho";
	}

	@GetMapping("/finalizar")
	public String finalizar(HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);

		Pedido pedido = new Pedido(usuario.getCarrinho(), usuario);

		pedidoService.insert(pedido);
		
		usuario.getCarrinho().clear();
		session.setAttribute("usuarioLogado", usuario);

		return "redirect:/";
	}

	@Cacheable
	@GetMapping("meusPedidos")
	public String meusPedidos(HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);
		if (usuario == null) {
			return "redirect:/login/formulario";
		}
		List<Pedido> pedidos = pedidoService.findByUsuarioId(usuario.getId());
		session.setAttribute("meusPedidos", pedidos);
		System.out.println(pedidos);

		return "pedido/meusPedidos";
	}

}
