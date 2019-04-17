package br.com.pimentel.repositories.itens;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.Item;

/**
 * Item - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**
	 * Retorna a quantidade de Itens por {@link Status}
	 * @param status {@link Status}
	 * @return Quantidade de Itens por {@link Status}
	 */
	public Integer countByStatus(Status status);
	
	/**
	 * Retorna Itens pelo Tipo
	 * @param tipo Tipo a ser buscado
	 * @return Lista com Itens do tipo buscado
	 */
	public List<Item> findByTipo(ItemTipo tipo);
	
	/**
	 * Busca itens com quantidade maior que o parametro
	 * @param quantidade Quantidade base
	 * @return Lista com Itens
	 */
	public List<Item> findByQuantidadeGreaterThan(Integer quantidade);

}
