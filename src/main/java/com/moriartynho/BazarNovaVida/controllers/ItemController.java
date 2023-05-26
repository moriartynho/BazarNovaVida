package com.moriartynho.BazarNovaVida.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.moriartynho.BazarNovaVida.dto.NovoItem;
import com.moriartynho.BazarNovaVida.models.itens.Item;
import com.moriartynho.BazarNovaVida.models.itens.imagem.Imagem;
import com.moriartynho.BazarNovaVida.models.usuario.TipoDeUsuario;
import com.moriartynho.BazarNovaVida.models.usuario.Usuario;
import com.moriartynho.BazarNovaVida.services.ImagemService;
import com.moriartynho.BazarNovaVida.services.ItemService;
import com.moriartynho.BazarNovaVida.services.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ImagemService imagemService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("formulario")
	public String formulario(NovoItem novo, HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);
		if (usuario == null) {
			return "redirect:/login/formulario";
		}

		if (usuario.getTipoDeUsuario() == TipoDeUsuario.ADMINISTRADOR) {
			return "item/novoItemForm";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/selecionar")
	public String itemPorId(@RequestParam Long id, Model model) {
		Item item = itemService.findById(id);
		model.addAttribute("item", item);
		return "item/itemSelecionado";
	}

	@PostMapping("novo")
	public String novo(@RequestParam MultipartFile imgFile, @Valid NovoItem novoItem, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return "item/novoItemForm";
		}

		Item item = novoItem.toItem();
		Imagem imagem = imagemService.dadosToImagem(imgFile);
		item.setImagem(imagem);
		itemService.insert(item, imagem);

		return "redirect:/";

	}

	@GetMapping("/adicionar")
	public String adicionarAoCarrinho(@RequestParam Long id, HttpSession session) {
		Usuario usuario = usuarioService.usuarioLogado(session);
		if (usuario == null) {
			return "redirect:/login/formulario";
		}

		itemService.adicionarAoCarrinho(usuario, id);

		session.setAttribute("carrinho", usuario.getCarrinho());

		BigDecimal totalPedido = usuario.getCarrinho().stream().map(Item::getValorDoItem).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		session.setAttribute("totalPedido", totalPedido.doubleValue());
		return "redirect:/";
	}
}
