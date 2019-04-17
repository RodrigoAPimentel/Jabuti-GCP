package br.com.pimentel.repositories.itens;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.models.itens.HQ;

/**
 * Historia em Quadrinhos - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface HQRepository extends JpaRepository<HQ, Integer> {
	
	/**
	 * Busca HQ por Universo
	 * @param universo Universo a ser buscado o HQ
	 * @return Lista de HQ por Universo
	 */
	public List<HQ> findByUniverso(String universo);

}
