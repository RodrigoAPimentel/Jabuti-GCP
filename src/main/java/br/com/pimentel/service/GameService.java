/**
 * 
 */
package br.com.pimentel.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.itens.DLC;
import br.com.pimentel.models.itens.Game;
import br.com.pimentel.repositories.itens.GameRepository;

/**
 * classe Service de Jogo de Console ou Computador
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class GameService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(GameService.class);
	
	@Autowired
	private GameRepository repository;
	
	/**
	 * Salva o Item do tipo Jogo de Console ou Computador
	 * @param game Item do tipo Jogo de Console ou Computador
	 */
	@Transactional
	public void salvar(Game game) {
		logger.info(" ==> Salvando GAME com codigo: [{}]", game.getCodigo());
		
		game.setTipo(ItemTipo.GAMES);
		game.setQuantidadeDeEmprestimos(0);
		
		DLC dlc = new DLC(game.getDlc().getTituloDLC(), game.getDlc().getFonteDLC());
		
		game.setDlc(dlc);
		
		repository.save(game);
	}
	
	/**
	 * Remove o Item do tipo Jogo de Console ou Computador
	 * @param game Item do tipo Jogo de Console ou Computador
	 */
	@Transactional
	public void remover(Game game) {
		logger.info(" ==> Removendo GAME com codigo: [{}]", game.getCodigo());
		repository.delete(game);
	}
	
	/**
	 * Atualiza o Item do tipo Jogo de Console ou Computador
	 * @param game Item do tipo Jogo de Console ou Computador
	 */
	@Transactional
	public void atualizar(Game game) {
		logger.info(" ==> Atualizando GAME: [{}]", game.getCodigo());		
		
		game.setTipo(ItemTipo.GAMES);
		
		repository.save(game);
	}
	
	/**
	 * Busca Jogo de Console ou Computador pelo id
	 * @param id Id do Jogo de Console ou Computador
	 * @return Jogo de Console ou Computador
	 */
	@Transactional
	public Game buscarById(Integer id){
		logger.info(" ==> Buscando Jogo de Console ou Computador pelo Id: [{}]", id);
		
		return repository.findById(id).get();
	}

}
