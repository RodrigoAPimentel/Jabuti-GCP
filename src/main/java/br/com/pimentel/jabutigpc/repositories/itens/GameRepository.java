package br.com.pimentel.jabutigpc.repositories.itens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.jabutigpc.model.itens.Game;

/**
 * Jogo de Console ou Computador - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
