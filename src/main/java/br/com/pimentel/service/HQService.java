package br.com.pimentel.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.itens.HQ;
import br.com.pimentel.repositories.itens.HQRepository;

/**
 * classe Service de Historia em Quadrinhos
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class HQService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(HQService.class);
	
	@Autowired
	private HQRepository repository;
	
	/**
	 * Salva o Item do tipo HQ
	 * @param hq Item do tipo HQ
	 */
	@Transactional
	public void salvar(HQ hq) {
		logger.info(" ==> Salvando HQ: [{}]", hq.getTitulo());
		
		hq.setTipo(ItemTipo.HQ);
		hq.setQuantidadeDeEmprestimos(0);
		
		repository.save(hq);
	}
	
	/**
	 * Remove o Item do tipo HQ
	 * @param hq Item do tipo HQ
	 */
	@Transactional
	public void remover(HQ hq) {
		logger.info(" ==> Removendo HQ: [{}]", hq.getTitulo());
		
		repository.delete(hq);
	}
	
	/**
	 * Busca o HQ pelo id
	 * @param id Id do HQ
	 * @return HQ
	 */
	@Transactional
	public HQ buscarById(Integer id){
		logger.info(" ==> Buscando HQ pelo Id: [{}]", id);
		
		return repository.findById(id).get();
	}
	
	/**
	 * Busca todos os HQ's
	 * @return Lista com todos os HQ's
	 */
	@Transactional
	public List<HQ> buscarTodos(){
		logger.info(" ==> Buscando todos os HQ's");
		
		return repository.findAll();
	}
	
	/**
	 * Atualiza o Item do tipo HQ
	 * @param hq Item do tipo HQ
	 */
	@Transactional
	public void atualizar(HQ hq) {
		logger.info(" ==> Atualizando HQ: [{}]", hq.getCodigo());		
		
		hq.setTipo(ItemTipo.HQ);
		
		repository.save(hq);
	}
	
	/**
	 * Todos os Universos de HQ
	 * @return Lista com todos os Universos de HQ
	 */
	public List<String> listUniversos(){
		logger.info(" ==> Buscando todos os Universos de HQ presentes no BD");
		
		List<String> universos = new ArrayList<>();
		List<HQ> todosHQ = buscarTodos();
		for (HQ hq : todosHQ) {
			universos.add(hq.getUniverso());
		}
		return universos;
	}
	
	public List<HQ> listHQByUniverso(String universo){
		logger.info(" ==> Buscando todos HQ's do Universo [{}]", universo);
		
		return repository.findByUniverso(universo);
	}
	

}
