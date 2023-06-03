package com.moriartynho.BazarNovaVida.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return (usuarioService.verificarLogin(session)) ? "pedido/carrinho" : "redirect:/login/formulario";
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

		return "pedido/meusPedidos";
	}

	@GetMapping("/selecionar")
	public String pedidoPorId(@RequestParam Long id, Model model, HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);
		Pedido pedido = pedidoService.findById(id);
		if (usuario.getId() == pedido.getUsuario().getId()) {
			model.addAttribute("pedido", pedido);
			return "pedido/pedidoSelecionado";
		}
		return "pedido/meusPedidos";

	}
	
	@GetMapping("/cancelar")
	public String cancelarPedido(@RequestParam Long id, HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);
		Pedido pedido = pedidoService.findById(id);
		if (usuario.getId() == pedido.getUsuario().getId()) {
			pedidoService.cancelarPedido(pedido);
			return "pedido/meusPedidos";
		}
		return "pedido/pedidoSelecionado";
	}
	
	@GetMapping("todosPedidos")
	public String todosPedidos(HttpSession session){
		if(usuarioService.verificarPermissao(session)) {
			List<Pedido> pedidos = pedidoService.findAll();
			session.setAttribute("todosPedidos", pedidos);
			return "pedido/todosPedidos";
		}
		return "redirect:/";
	}

}
