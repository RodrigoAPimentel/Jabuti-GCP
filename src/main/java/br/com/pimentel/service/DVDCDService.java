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
import br.com.pimentel.models.itens.DVDCD;
import br.com.pimentel.repositories.itens.DVDCDRepository;

/**
 * classe Service de DVD(Digital Video Disc) ou CD(Compact Disc)
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class DVDCDService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(DVDCDService.class);
	
	@Autowired
	private DVDCDRepository repository;
	
	/**
	 * Salva o Item do tipo DVD ou CD
	 * @param dvdcd Item do tipo DVD ou CD
	 */
	@Transactional
	public void salvar(DVDCD dvdcd) {
		logger.info(" ==> Salvando DVDCD com codigo: [{}]", dvdcd.getCodigo());
		
		dvdcd.setTipo(ItemTipo.DVDCD);
		dvdcd.setQuantidadeDeEmprestimos(0);
		
		repository.save(dvdcd);
	}
	
	/**
	 * Remove o Item do tipo DVD ou CD
	 * @param dvdcd Item do tipo DVD ou CD
	 */
	@Transactional
	public void remover(DVDCD dvdcd) {
		logger.info(" ==> Removendo DVDCD com codigo: [{}]", dvdcd.getCodigo());
		repository.delete(dvdcd);
	}
	
	/**
	 * Atualiza o Item do tipo DVD ou CD
	 * @param dvdcd Item do tipo DVD ou CD
	 */
	@Transactional
	public void atualizar(DVDCD dvdcd) {
		logger.info(" ==> Atualizando DVDCD: [{}]", dvdcd.getCodigo());		
		
		dvdcd.setTipo(ItemTipo.DVDCD);
		
		repository.save(dvdcd);
	}
	
	/**
	 * Busca o DVD ou CD pelo id
	 * @param id Id do DVD ou CD
	 * @return DVD ou CD
	 */
	@Transactional
	public DVDCD buscarById(Integer id){
		logger.info(" ==> Buscando DVD ou CD pelo Id: [{}]", id);
		
		return repository.findById(id).get();
	}

}
