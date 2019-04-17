/**
 * 
 */
package br.com.pimentel.controllers;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.service.HQService;
import br.com.pimentel.service.ItemService;

/**
 * classe Controle do Dashboard
 * 
 * @author Rodrigo Pimentel
 */
@Controller
@RequestMapping("dashboard")
public class DashboardController implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	private static final long serialVersionUID = -5369860440517622782L;
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private HQService hqService;
	
	@GetMapping
	public ModelAndView dashboard() {	
		logger.info("@@ ABRINDO DASHBOARD");
		
		ModelAndView mv = new ModelAndView("dashboard"); 
		
		mv.addObject("itens", itemService.buscarTodos());
		
		mv.addObject("qtdItens", itemService.quantidadeItens());
		mv.addObject("qtdEmprestado", itemService.quantidadeItemByStatus(Status.EMPRESTADO));
		mv.addObject("qtdNaColecao", itemService.quantidadeItemByStatus(Status.NACOLECAO));
		
		mv.addObject("percNaColecao", itemService.porcentagemItemByStatus(Status.NACOLECAO));
		mv.addObject("percEmprestado", itemService.porcentagemItemByStatus(Status.EMPRESTADO));
		mv.addObject("percVendido", itemService.porcentagemItemByStatus(Status.VENDIDO));
		mv.addObject("percParaVender", itemService.porcentagemItemByStatus(Status.PARAVENDER));
		mv.addObject("percNaoEmprestavel", itemService.porcentagemItemByStatus(Status.NAOEMPRESTAVEL));
		mv.addObject("percDesejavel", itemService.porcentagemItemByStatus(Status.DESEJAVEL));
		mv.addObject("percAvariado", itemService.porcentagemItemByStatus(Status.AVARIADO));
		mv.addObject("percEmReparo", itemService.porcentagemItemByStatus(Status.EMREPARO));			
		
		mv.addObject("tipos", ItemTipo.values());
		mv.addObject("universos", hqService.listUniversos());
		
		return mv;	
	}
	
	@GetMapping("/{tipo}")
	public ModelAndView dashboard(@PathVariable("tipo") String tipo) {		
		logger.info("@@ ABRINDO DASHBOARD");
		
		ModelAndView mv = new ModelAndView("tabelaItem"); 
		
		mv.addObject("qtdItens", itemService.quantidadeItens());
		mv.addObject("qtdEmprestado", itemService.quantidadeItemByStatus(Status.EMPRESTADO));
		mv.addObject("qtdNaColecao", itemService.quantidadeItemByStatus(Status.NACOLECAO));
		
		mv.addObject("percNaColecao", itemService.porcentagemItemByStatus(Status.NACOLECAO));
		mv.addObject("percEmprestado", itemService.porcentagemItemByStatus(Status.EMPRESTADO));
		mv.addObject("percVendido", itemService.porcentagemItemByStatus(Status.VENDIDO));
		mv.addObject("percParaVender", itemService.porcentagemItemByStatus(Status.PARAVENDER));
		mv.addObject("percNaoEmprestavel", itemService.porcentagemItemByStatus(Status.NAOEMPRESTAVEL));
		mv.addObject("percDesejavel", itemService.porcentagemItemByStatus(Status.DESEJAVEL));
		mv.addObject("percAvariado", itemService.porcentagemItemByStatus(Status.AVARIADO));
		mv.addObject("percEmReparo", itemService.porcentagemItemByStatus(Status.EMREPARO));			
		
		mv.addObject("tipos", ItemTipo.values());
		mv.addObject("universos", hqService.listUniversos());
		
		switch (tipo) {
			case "HQ":
				mv.addObject("itens", itemService.buscarByTipo(ItemTipo.HQ));				
				break;
			case "GAMES":
				mv.addObject("itens", itemService.buscarByTipo(ItemTipo.GAMES));
				break;
			case "DVDCD":
				mv.addObject("itens", itemService.buscarByTipo(ItemTipo.DVDCD));
				break;
			case "TABULEIRO":
				mv.addObject("itens", itemService.buscarByTipo(ItemTipo.TABULEIRO));
				break;
			case "todos":
				mv.addObject("itens", itemService.buscarTodos());
				break;
		}		
		
		return mv;	
	}
	
	@GetMapping("/{tipo}/{universo}")
	public ModelAndView dashboard(@PathVariable("tipo") String tipo, @PathVariable("universo") String universo) {		
		logger.info("@@ ABRINDO DASHBOARD");
		
		ModelAndView mv = new ModelAndView("tabelaItem"); 
		
		mv.addObject("qtdItens", itemService.quantidadeItens());
		mv.addObject("qtdEmprestado", itemService.quantidadeItemByStatus(Status.EMPRESTADO));
		mv.addObject("qtdNaColecao", itemService.quantidadeItemByStatus(Status.NACOLECAO));
		
		mv.addObject("percNaColecao", itemService.porcentagemItemByStatus(Status.NACOLECAO));
		mv.addObject("percEmprestado", itemService.porcentagemItemByStatus(Status.EMPRESTADO));
		mv.addObject("percVendido", itemService.porcentagemItemByStatus(Status.VENDIDO));
		mv.addObject("percParaVender", itemService.porcentagemItemByStatus(Status.PARAVENDER));
		mv.addObject("percNaoEmprestavel", itemService.porcentagemItemByStatus(Status.NAOEMPRESTAVEL));
		mv.addObject("percDesejavel", itemService.porcentagemItemByStatus(Status.DESEJAVEL));
		mv.addObject("percAvariado", itemService.porcentagemItemByStatus(Status.AVARIADO));
		mv.addObject("percEmReparo", itemService.porcentagemItemByStatus(Status.EMREPARO));			
		
		mv.addObject("tipos", ItemTipo.values());
		mv.addObject("universos", hqService.listUniversos());
		
		if (universo.equals("todos")) {
			mv.addObject("itens", hqService.buscarTodos());
		} else {
			mv.addObject("itens", hqService.listHQByUniverso(universo));
		}
		
		return mv;	
	}
	
}
