package br.com.pimentel.jabutigpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.jabutigpc.model.Pessoa;

/**
 * Pessoa Fisica - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}
