package br.com.pimentel.jabutigpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.jabutigpc.model.Endereco;

/**
 * Endereço - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
