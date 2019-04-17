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
import br.com.pimentel.models.itens.JogoDeTabuleiro;
import br.com.pimentel.repositories.itens.JogoDeTabuleiroRepository;

/**
 * classe Service de Jogo de Tabuleiro
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class JogoDeTabuleiroService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(JogoDeTabuleiroService.class);
	
	@Autowired
	private JogoDeTabuleiroRepository repository;
	
	/**
	 * Salva o Item do tipo Jogo de Tabuleiro
	 * @param jogoDeTabuleiro Item do tipo Jogo de Tabuleiro
	 */
	@Transactional
	public void salvar(JogoDeTabuleiro jogoDeTabuleiro) {
		logger.info(" ==> Salvando JOGO DE TABULEIRO com codigo: [{}]", jogoDeTabuleiro.getCodigo());
		
		jogoDeTabuleiro.setTipo(ItemTipo.TABULEIRO);
		jogoDeTabuleiro.setQuantidadeDeEmprestimos(0);
		
		repository.save(jogoDeTabuleiro);
	}
	
	/**
	 * Remove o Item do tipo Jogo de Tabuleiro
	 * @param jogoDeTabuleiro Item do tipo Jogo de Tabuleiro
	 */
	@Transactional
	public void remover(JogoDeTabuleiro jogoDeTabuleiro) {
		logger.info(" ==> Removendo JOGO DE TABULEIRO com codigo: [{}]", jogoDeTabuleiro.getCodigo());
		repository.delete(jogoDeTabuleiro);
	}
	
	/**
	 * Atualiza o Item do tipo Jogo de Tabuleiro
	 * @param jogoDeTabuleiro Item do tipo Jogo de Tabuleiro
	 */
	@Transactional
	public void atualizar(JogoDeTabuleiro jogoDeTabuleiro) {
		logger.info(" ==> Atualizando JOGO DE TABULEIRO: [{}]", jogoDeTabuleiro.getCodigo());		
		
		jogoDeTabuleiro.setTipo(ItemTipo.TABULEIRO);
		
		repository.save(jogoDeTabuleiro);
	}
	
	/**
	 * Busca Jogo de Tabuleiro pelo id
	 * @param id Id do Jogo de Tabuleiro
	 * @return Jogo de Tabuleiro
	 */
	@Transactional
	public JogoDeTabuleiro buscarById(Integer id){
		logger.info(" ==> Buscando Jogo de Tabuleiro pelo Id: [{}]", id);
		
		return repository.findById(id).get();
	}

}
