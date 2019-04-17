package br.com.pimentel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.models.Usuario;

/**
 * Usuario - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}
