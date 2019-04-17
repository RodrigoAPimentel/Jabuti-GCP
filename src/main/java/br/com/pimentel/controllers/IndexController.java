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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pimentel.service.ItemService;

/**
 * classe Controle do Dashboard
 * 
 * @author Rodrigo Pimentel
 */
@Controller
@RequestMapping("/")
public class IndexController implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private static final long serialVersionUID = -5369860440517622782L;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public ModelAndView dashboard() {	
		logger.info("@@ ABRINDO INDEX"); 
		
		ModelAndView mv = new ModelAndView("index"); 
		
		mv.addObject("itens", itemService.buscarTodos());
		return mv;
	}
	
}
