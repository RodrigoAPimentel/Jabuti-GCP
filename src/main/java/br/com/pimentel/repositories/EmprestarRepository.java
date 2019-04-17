package br.com.pimentel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.models.Emprestar;
import br.com.pimentel.models.Usuario;
import br.com.pimentel.models.itens.Item;

/**
 * Emprestar - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface EmprestarRepository extends JpaRepository<Emprestar, Integer> {
	
	/**
	 * Retorna Lista de Emprestimo por Usuario
	 * @param cpf CPF do Usuario a ser buscado
	 * @return Lista de Emprestimos
	 */
	public List<Emprestar> findByUsuario(Usuario usuario);
	
	/**
	 * Buscar emprestimo por Item
	 * @param item Item a ser buscado
	 * @return Emprestimo do Item buscado
	 */
	public Emprestar findByItemAndEmprestadoTrue(Item item);
}
