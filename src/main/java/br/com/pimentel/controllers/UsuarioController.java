package br.com.pimentel.controllers;

import java.io.Serializable;
import java.util.List;

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
import br.com.pimentel.models.Usuario;
import br.com.pimentel.models.enums.NivelUsuario;
import br.com.pimentel.service.EmprestarService;
import br.com.pimentel.service.UsuarioService;

/**
 * Classe Controle de Usuario
 * 
 * @author Rodrigo Pimentel
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	private static final long serialVersionUID = -5369860440517622782L;
	
	private static final String RETORNADASHBOARD = "redirect:/dashboard";
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmprestarService emprestarService;
	
	@GetMapping
	public ModelAndView usuario() {
		logger.info("@@ ABRINDO CADASTRAR USUARIO");
		
		ModelAndView mv = new ModelAndView("usuario/addUsuario");
		
		mv.addObject("nivel", NivelUsuario.values());
		mv.addObject("usuario", new Usuario());
		
		return mv;
	}
		
	@PostMapping("/add")
	public String addUsuario(Usuario usuario) {
		logger.info("@@ CADASTRANDO USUARIO [{}]", usuario.getCpf());
		
		usuarioService.salvar(usuario);
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		logger.info("@@ LISTANDO USUARIOS");
		
		ModelAndView mv = new ModelAndView("usuario/listarUsuario");
		
		mv.addObject("listaDeUsuarios", usuarioService.buscarTodos());
		
		return mv;
	}
	
	@GetMapping("updateView/{cpf}")
	public ModelAndView updateView(@PathVariable("cpf") String cpf) {
		logger.info("@@ ABRINDO EDITAR USUARIO [{}]", cpf);
		
		ModelAndView mv = new ModelAndView("usuario/updateUsuario");
		
		mv.addObject("nivel", NivelUsuario.values());
		mv.addObject("usuario", usuarioService.buscarByCpf(cpf));
		
		return mv;
	}
	
	@PostMapping("update")
	public String update(Usuario usuario) {
		logger.info("@@ ATUALIZANDO USUARIO {}", usuario.getCpf());
		
		usuarioService.salvar(usuario);
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("delete/{cpf}")
	public String delete(@PathVariable("cpf") String cpf) {
		logger.info("@@ EXCLUINDO USUARIO [{}]", cpf);
		
		usuarioService.excluir(cpf);
		
		return RETORNADASHBOARD;
	}
	
	@GetMapping("emprestimos/{cpf}")
	public ModelAndView emprestimos(@PathVariable("cpf") String cpf) {
		
		ModelAndView mv = new ModelAndView("usuario/listarEmprestimos");
		
		Usuario userAux = usuarioService.buscarByCpf(cpf).get();
		List<Emprestar> listEmpAux = emprestarService.emprestimos(userAux);
		
		mv.addObject("emprestimos", listEmpAux);
		
		return mv;
	}
	
	@GetMapping("sair")
	public String sair() {
		logger.info("@@ VOLTANDO PARA A DASHBOARD");
		
		return RETORNADASHBOARD;
	}

}
