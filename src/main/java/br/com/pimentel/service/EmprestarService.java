package br.com.pimentel.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pimentel.models.Emprestar;
import br.com.pimentel.models.Usuario;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.DVDCD;
import br.com.pimentel.models.itens.Game;
import br.com.pimentel.models.itens.HQ;
import br.com.pimentel.models.itens.Item;
import br.com.pimentel.models.itens.JogoDeTabuleiro;
import br.com.pimentel.repositories.EmprestarRepository;

/**
 * classe Service de Emprestar
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class EmprestarService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(EmprestarService.class);
	
	@Autowired
	private EmprestarRepository emprestarRepository;
	@Autowired
	private HQService hqService;
	@Autowired
	private DVDCDService dvdService;
	@Autowired
	private GameService gameService;
	@Autowired
	private JogoDeTabuleiroService tabuleiroService;
	
	/**
	 * Empresta um item
	 * @param emprestar Objeto do tipo Emprestar
	 */
	public void emprestar(Emprestar emprestar) {
		logger.info(" ==> Emprestando o ITEM [{}] para o usuario [{}]", emprestar.getItem().getCodigo(), emprestar.getUsuario().getCpf());
		
		Item itemAux = emprestar.getItem();
		
		switch (itemAux.getTipo()) {
			case HQ:				
				HQ hqAux = hqService.buscarById(emprestar.getItem().getCodigo());
				
				hqAux.setStatus(Status.EMPRESTADO);
				hqAux.setQuantidadeDeEmprestimos(hqAux.getQuantidadeDeEmprestimos()+1);
				hqService.atualizar(hqAux);
				break;	
			case DVDCD:				
				DVDCD dvdAux = dvdService.buscarById(emprestar.getItem().getCodigo());
				
				dvdAux.setStatus(Status.EMPRESTADO);
				dvdAux.setQuantidadeDeEmprestimos(dvdAux.getQuantidadeDeEmprestimos()+1);
				dvdService.atualizar(dvdAux);
				break;
			case GAMES:				
				Game gameAux = gameService.buscarById(emprestar.getItem().getCodigo());
				
				gameAux.setStatus(Status.EMPRESTADO);
				gameAux.setQuantidadeDeEmprestimos(gameAux.getQuantidadeDeEmprestimos()+1);
				gameService.atualizar(gameAux);
				break;
			case TABULEIRO:				
				JogoDeTabuleiro tabuleiroAux = tabuleiroService.buscarById(emprestar.getItem().getCodigo());
				
				tabuleiroAux.setStatus(Status.EMPRESTADO);
				tabuleiroAux.setQuantidadeDeEmprestimos(tabuleiroAux.getQuantidadeDeEmprestimos()+1);
				tabuleiroService.atualizar(tabuleiroAux);
				break;
		}
		
		emprestar.setDataEmprestimo(LocalDate.now());
		emprestar.setEmprestado(true);
		
		emprestarRepository.save(emprestar);
	}
	
	/**
	 * Devolver um item
	 * @param emprestar Objeto do tipo Emprestar
	 */
	public void devolver(Emprestar emprestar) {
		logger.info(" ==> Devolvendo o ITEM [{}] para o usuario [{}]", emprestar.getItem().getCodigo(), emprestar.getUsuario().getCpf());
		
		Item itemAux = emprestar.getItem();
		
		switch (itemAux.getTipo()) {
			case HQ:				
				HQ hqAux = hqService.buscarById(emprestar.getItem().getCodigo());
				
				hqAux.setStatus(Status.NACOLECAO);
				hqService.atualizar(hqAux);
				break;	
			case DVDCD:				
				DVDCD dvdAux = dvdService.buscarById(emprestar.getItem().getCodigo());
				
				dvdAux.setStatus(Status.NACOLECAO);
				dvdService.atualizar(dvdAux);
				break;
			case GAMES:				
				Game gameAux = gameService.buscarById(emprestar.getItem().getCodigo());
				
				gameAux.setStatus(Status.NACOLECAO);
				gameService.atualizar(gameAux);
				break;
			case TABULEIRO:				
				JogoDeTabuleiro tabuleiroAux = tabuleiroService.buscarById(emprestar.getItem().getCodigo());
				
				tabuleiroAux.setStatus(Status.NACOLECAO);
				tabuleiroService.atualizar(tabuleiroAux);
				break;
		}
		
		emprestar.setDataQueFoiDevolvido(LocalDate.now());
		emprestar.setEmprestado(false);
		
		emprestarRepository.save(emprestar);
	}
	
	/**
	 * Busca todos os emprestimos de um Usuario
	 * @param usuario Usuario a ser buscado os emprstimos
	 * @return Lista de emprstimos do usuario
	 */
	public List<Emprestar> emprestimos(Usuario usuario){
		logger.info(" ==> Buscando todos os emprestimos do usuario[{}]", usuario.getCpf());
				
		return emprestarRepository.findByUsuario(usuario);
	}
	
	/**
	 * Busca emprestimo por Item
	 * @param item Item a ser buscado
	 * @return Emprestimo do item Buscado
	 */
	public Emprestar buscarEmprestimoPorItem(Item item) {
		logger.info(" ==> Buscando emprestimo por Item [{}]", item.getCodigo());
		
		return emprestarRepository.findByItemAndEmprestadoTrue(item);
	}
	
	
	
}
