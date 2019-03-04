package br.com.pimentel.jabutigpc.repositories.itens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.jabutigpc.model.itens.JogoDeTabuleiro;

/**
 * Jogo de Tabuleiro - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface JogoDeTabuleiroRepository extends JpaRepository<JogoDeTabuleiro, Integer> {

}
