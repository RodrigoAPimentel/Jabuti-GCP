/**
 * 
 */
package br.com.pimentel.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.Item;
import br.com.pimentel.repositories.itens.ItemRepository;

/**
 * classe Service de Item
 * 
 * @author Rodrigo Pimentel
 */
@Service
public class ItemService implements Serializable {

	private static final long serialVersionUID = -1035634260261568467L;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	private ItemRepository repository;
	
	/**
	 * Busca todos os Itens
	 * @return Todos os Itens
	 */
	@Transactional
	public List<Item> buscarTodos() {
		logger.info(" ==> Buscando todos os ITENS");
		return repository.findAll();
	}
	
	/**
	 * Busca item pelo id
	 * @param id Id do item
	 * @return item
	 */
	@Transactional
	public Optional<Item> buscarById(Integer id){
		logger.info(" ==> Buscando ITEM pelo Id: [{}]", id);
		
		return repository.findById(id);
	}
	
	/**
	 * Retorna a quantidade de Itens por {@link Status}
	 * @param status {@link Status}
	 * @return Quantidade de Itens por {@link Status}
	 */
	@Transactional
	public Integer quantidadeItemByStatus(Status status) {
		Integer qtd = repository.countByStatus(status);
		
		logger.info(" ==> Quantidade de ITENS com o STATUS: [{}] é {}", status, qtd);	
		
		return qtd;
	}
	
	/**
	 * Retorna a porcentagem de Itens por {@link Status}
	 * @param status {@link Status}
	 * @return Porcentagem de Itens por {@link Status}
	 */
	@Transactional
	public int porcentagemItemByStatus(Status status) {	
		Integer countStatus = repository.countByStatus(status);
		Double countTotal = (double) repository.count();
		Double total = (countStatus/countTotal)*100;		
		
		logger.info(" ==> Porcentagem de ITENS com o STATUS: [{}] é {}%", status, total);
		
		return total.intValue();
	}
	
	/**
	 * Retorna a quantidade de Itens na Coleção
	 * @return Quantidade de Itens na Coleção
	 */
	@Transactional
	public Long quantidadeItens() {
		Long qtd = repository.count();
		
		logger.info(" ==> Quantidade de ITENS na coleção = {}", qtd);		
		
		return qtd;
	}
	
	/**
	 * Exclui o Item
	 * @param id Id do Item
	 */
	@Transactional
	public void excluir(Integer id) {
		logger.info(" ==> Excluindo o ITEM {}", id);	
		
		repository.deleteById(id);
	}
	
	/**
	 * Busca Item pelo tipo
	 * @param tipo Tipo do Item a ser buscado
	 * @return Lista de Itens
	 */
	@Transactional
	public List<Item> buscarByTipo(ItemTipo tipo){
		logger.info(" ==> Buscando todos os ITENS do Tipo: [{}]", tipo);
		
		return repository.findByTipo(tipo);
	}
	
	/**
	 * Busca todos os Itens repetidos
	 * @return Lista com itens repetidos
	 */
	@Transactional
	public List<Item> buscarRepetidos(){
		logger.info(" ==> Buscando todos os ITENS repetidos");
		
		return repository.findByQuantidadeGreaterThan(1);
	}

}
