package br.com.pimentel.controllers;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pimentel.models.Emprestar;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.DVDCD;
import br.com.pimentel.models.itens.Game;
import br.com.pimentel.models.itens.HQ;
import br.com.pimentel.models.itens.Item;
import br.com.pimentel.models.itens.JogoDeTabuleiro;
import br.com.pimentel.service.EmprestarService;
import br.com.pimentel.service.ItemService;
import br.com.pimentel.service.UsuarioService;

@Controller
@RequestMapping("emprestarDevolver")
public class EmprestarController implements Serializable {

	private static final long serialVersionUID = 2542146040651315517L;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	private static final String RETORNADASHBOARD = "redirect:/dashboard";
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmprestarService emprestarService;
		
	@GetMapping("{id}")
	public ModelAndView emprestarView(@PathVariable("id") Integer id) {
		ModelAndView mv;
		
		Item itemAux = itemService.buscarById(id).get();
		
		switch (itemAux.getTipo()) {
			case HQ:
				HQ hq = (HQ) itemAux;
				
				if (hq.getStatus() == Status.EMPRESTADO) {
					logger.info("Devolvendo o Item [{}]", itemAux.getCodigo());
					
					Emprestar emprestar = emprestarService.buscarEmprestimoPorItem(itemAux);					
					
					emprestarService.devolver(emprestar);
					
					return new ModelAndView(RETORNADASHBOARD);					
				}else {
					Emprestar emprestar = new Emprestar();
					
					emprestar.setItem(itemAux);
					
					mv= new ModelAndView("emprestar");
					
					mv.addObject("emprestar", emprestar);
					mv.addObject("usuarios", usuarioService.buscarTodos());
					
					return mv;
				}
			case DVDCD:
				DVDCD dvd = (DVDCD) itemAux;
				
				if (dvd.getStatus() == Status.EMPRESTADO) {
					logger.info("Devolvendo o Item [{}]", itemAux.getCodigo());
					
					Emprestar emprestar = emprestarService.buscarEmprestimoPorItem(itemAux);
					
					emprestarService.devolver(emprestar);
					
					return new ModelAndView(RETORNADASHBOARD);
				}else {
					Emprestar emprestar = new Emprestar();
					
					emprestar.setItem(itemAux);
					
					mv= new ModelAndView("emprestar");
					
					mv.addObject("emprestar", emprestar);
					mv.addObject("usuarios", usuarioService.buscarTodos());
					
					return mv;					
				}
			case GAMES:
				Game game = (Game) itemAux;
				
				if (game.getStatus() == Status.EMPRESTADO) {
					logger.info("Devolvendo o Item [{}]", itemAux.getCodigo());
					
					Emprestar emprestar = emprestarService.buscarEmprestimoPorItem(itemAux);
					
					emprestarService.devolver(emprestar);
					
					return new ModelAndView(RETORNADASHBOARD);
				}else {
					Emprestar emprestar = new Emprestar();
					
					emprestar.setItem(itemAux);
					
					mv= new ModelAndView("emprestar");
					
					mv.addObject("emprestar", emprestar);
					mv.addObject("usuarios", usuarioService.buscarTodos());
					
					return mv;
				}
			case TABULEIRO:
				JogoDeTabuleiro tabuleiro = (JogoDeTabuleiro) itemAux;
				
				if (tabuleiro.getStatus() == Status.EMPRESTADO) {
					logger.info("Devolvendo o Item [{}]", itemAux.getCodigo());
					
					Emprestar emprestar = emprestarService.buscarEmprestimoPorItem(itemAux);
					
					emprestarService.devolver(emprestar);
					
					return new ModelAndView(RETORNADASHBOARD);
				}else {
					Emprestar emprestar = new Emprestar();
					
					emprestar.setItem(itemAux);
					
					mv= new ModelAndView("emprestar");
					
					mv.addObject("emprestar", emprestar);
					mv.addObject("usuarios", usuarioService.buscarTodos());
					
					return mv;
				}				
				
		}
		return null;
	}
	
	@PostMapping
	public String emprestar(Emprestar emprestar) {
		logger.info("Emprestando o Item [{}] ao Usuario [{}] com data de devolução de [{}]", emprestar.getItem().getCodigo(), emprestar.getUsuario().getCpf(), emprestar.getDataDevolucao());
		
		emprestarService.emprestar(emprestar);
		
		return RETORNADASHBOARD;
	}

}
