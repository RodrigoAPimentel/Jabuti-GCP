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

import br.com.pimentel.models.enums.Estado;
import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.enums.Plataforma;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.DVDCD;
import br.com.pimentel.models.itens.Game;
import br.com.pimentel.models.itens.HQ;
import br.com.pimentel.models.itens.Item;
import br.com.pimentel.models.itens.JogoDeTabuleiro;
import br.com.pimentel.service.DVDCDService;
import br.com.pimentel.service.GameService;
import br.com.pimentel.service.HQService;
import br.com.pimentel.service.ItemService;
import br.com.pimentel.service.JogoDeTabuleiroService;

/**
 * lasse Controle de Item
 * 
 * @author Rodrigo Pimentel
 */
@Controller
@RequestMapping("/item")
public class ItemController implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	private static final long serialVersionUID = -5369860440517622782L;
	
	private static final String RETORNADASHBOARD = "redirect:/dashboard";
	
	@Autowired
	private ItemService itemService;
	@Autowired 
	private DVDCDService dvdcdService;
	@Autowired 
	private GameService gameService;
	@Autowired 
	private HQService hqService;
	@Autowired 
	private JogoDeTabuleiroService jogoDeTabuleiroService;
	
	@GetMapping("repetidos")
	public ModelAndView itensRepetidos() {
		logger.info("@@ ABRINDO ITENS REPETIDOS");
		
		ModelAndView mv = new ModelAndView("tabelaItemRepetido"); 
		
		mv.addObject("itens", itemService.buscarRepetidos());	
				
		return mv;
	}	
	
	@GetMapping("hq")
	public ModelAndView addItemHQ() {
		logger.info("@@ ABRINDO CADASTRAR ITEM DO TIPO HQ");
		
		ModelAndView mv = new ModelAndView("itens/addItemHQ");
		
		mv.addObject("estado", Estado.values());
		mv.addObject("itemTipo", ItemTipo.values());
		mv.addObject("status", Status.values());
		
		mv.addObject("hq", new HQ());
		
		return mv;
	}
		
	@PostMapping("/addHQ")
	public String addHQ(HQ hq) {
		logger.info("@@ CADASTRANDO ITEM DO TIPO HQ");
		
		hqService.salvar(hq);
		
		logger.info("@@ ITEM DO TIPO HQ [{}] CADASTRADO", hq.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@PostMapping("/updateHQ")
	public String updateHQ(HQ hq) {
		logger.info("@@ ATUALIZANDO ITEM DO TIPO HQ");
		
		hqService.atualizar(hq);
		
		logger.info("@@ ITEM DO TIPO HQ [{}] ATUALIZADO", hq.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("dvd")
	public ModelAndView addItemDVDCD() {
		logger.info("@@ ABRINDO CADASTRAR ITEM DO TIPO DVD OU CD");
		
		ModelAndView mv = new ModelAndView("itens/addItemDVDCD");
		
		mv.addObject("estado", Estado.values());
		mv.addObject("itemTipo", ItemTipo.values());
		mv.addObject("status", Status.values());
		
		mv.addObject("dvd", new DVDCD());
		
		return mv;
	}
	
	@PostMapping("/addDVD")
	public String addDVDCD(DVDCD dvd) {
		logger.info("@@ CADASTRANDO ITEM DO TIPO DVD OU CD");
		
		dvdcdService.salvar(dvd);
		
		logger.info("@@ ITEM DO TIPO DVD OU CD [{}] CADASTRADO", dvd.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@PostMapping("/updateDVD")
	public String updateDVDCD(DVDCD dvd) {
		logger.info("@@ ATUALIZANDO ITEM DO TIPO DVD OU CD");
		
		dvdcdService.atualizar(dvd);
		
		logger.info("@@ ITEM DO TIPO DVD OU CD [{}] ATUALIZADO", dvd.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("tabuleiro")
	public ModelAndView addItemTabuleiro() {
		logger.info("@@ ABRINDO CADASTRAR ITEM DO TIPO JOGO DE TABULEIRO");
		
		ModelAndView mv = new ModelAndView("itens/addItemTabuleiro");
		
		mv.addObject("estado", Estado.values());
		mv.addObject("itemTipo", ItemTipo.values());
		mv.addObject("status", Status.values());
		
		mv.addObject("tabuleiro", new JogoDeTabuleiro());
		
		return mv;
	}
	
	@PostMapping("/addTabuleiro")
	public String addTabuleiro(JogoDeTabuleiro tabuleiro) {
		logger.info("@@ CADASTRANDO ITEM DO TIPO JOGO DE TABULEIRO");
		
		jogoDeTabuleiroService.salvar(tabuleiro);
		
		logger.info("@@ ITEM DO TIPO JOGO DE TABULEIRO [{}] CADASTRADO", tabuleiro.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@PostMapping("/updateTabuleiro")
	public String updateTabuleiro(JogoDeTabuleiro tabuleiro) {
		logger.info("@@ ATUALIZANDO ITEM DO TIPO JOGO DE TABULEIRO");
		
		jogoDeTabuleiroService.atualizar(tabuleiro);
		
		logger.info("@@ ITEM DO TIPO JOGO DE TABULEIRO [{}] ATUALIZADO", tabuleiro.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("game")
	public ModelAndView addItemGame() {
		logger.info("@@ ABRINDO CADASTRAR ITEM DO TIPO JOGO DE CONSOLE OU COMPUTADOR");
		
		ModelAndView mv = new ModelAndView("itens/addItemGame");
		
		mv.addObject("estado", Estado.values());
		mv.addObject("itemTipo", ItemTipo.values());
		mv.addObject("status", Status.values());
		mv.addObject("plataformas", Plataforma.values());
		
		mv.addObject("game", new Game());
		
		return mv;
	}
	
	@PostMapping("/addGame")
	public String addGame(Game game) {
		logger.info("@@ CADASTRANDO ITEM DO TIPO JOGO DE CONSOLE OU COMPUTADOR");
		
		gameService.salvar(game);
		
		logger.info("@@ ITEM DO TIPO JOGO DE CONSOLE OU COMPUTADOR [{}] CADASTRADO", game.getTitulo());
		
		return RETORNADASHBOARD;
	}
	
	@PostMapping("/updateGame")
	public String updateGame(Game game) {
		logger.info("@@ ATUALIZANDO ITEM DO TIPO JOGO DE CONSOLE OU COMPUTADOR");
		
		gameService.atualizar(game);
		
		logger.info("@@ ITEM DO TIPO JOGO DE CONSOLE OU COMPUTADOR [{}] ATUALIZADO", game.getTitulo());
		
		return RETORNADASHBOARD;
	}
		
	@GetMapping("editItem/{id}")
	public ModelAndView editItem(@PathVariable("id") Integer id) {		
		Item itemAux = itemService.buscarById(id).get();
		
		switch (itemAux.getTipo()) {
			case HQ:
				logger.info("@@ ABRINDO EDITAR ITEM DO TIPO HQ");
				
				ModelAndView mvHQ = new ModelAndView("itens/updateItemHQ");
				
				mvHQ.addObject("estado", Estado.values());
				mvHQ.addObject("itemTipo", ItemTipo.values());
				mvHQ.addObject("status", Status.values());
				
				mvHQ.addObject("hq", itemAux);
				
				return mvHQ;
			case DVDCD:
				logger.info("@@ ABRINDO EDITAR ITEM DO TIPO DVD OU CD");
				
				ModelAndView mvDVDCD = new ModelAndView("itens/updateItemDVDCD");
				
				mvDVDCD.addObject("estado", Estado.values());
				mvDVDCD.addObject("itemTipo", ItemTipo.values());
				mvDVDCD.addObject("status", Status.values());
				
				mvDVDCD.addObject("dvd", itemAux);
				
				return mvDVDCD;
			case GAMES:
				logger.info("@@ ABRINDO EDITAR ITEM DO TIPO JOGO DE CONSOLE OU COMPUTADOR");
				
				ModelAndView mvGame = new ModelAndView("itens/updateItemGame");
				
				mvGame.addObject("estado", Estado.values());
				mvGame.addObject("itemTipo", ItemTipo.values());
				mvGame.addObject("status", Status.values());
				mvGame.addObject("plataformas", Plataforma.values());
				
				mvGame.addObject("game", itemAux);
				
				return mvGame;
			case TABULEIRO:
				logger.info("@@ ABRINDO EDITAR ITEM DO TIPO JOGO DE TABULEIRO");
				
				ModelAndView mvTabuleiro = new ModelAndView("itens/updateItemTabuleiro");
				
				mvTabuleiro.addObject("estado", Estado.values());
				mvTabuleiro.addObject("itemTipo", ItemTipo.values());
				mvTabuleiro.addObject("status", Status.values());
				
				mvTabuleiro.addObject("tabuleiro", itemAux);
				
				return mvTabuleiro;				
		}		
		return null;
	}
	
	@GetMapping("excluirItem/{id}")
	public String excluirItem(@PathVariable("id") Integer id) {
		logger.info("@@ EXCLUINDO ITEM {}", id);
		
		itemService.excluir(id);
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("sair")
	public String sair() {
		logger.info("@@ VOLTANDO PARA A DASHBOARD");
		
		return RETORNADASHBOARD;
	}
		
}
