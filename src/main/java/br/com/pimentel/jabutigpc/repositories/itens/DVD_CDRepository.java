package br.com.pimentel.jabutigpc.repositories.itens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.jabutigpc.model.itens.DVD_CD;

/**
 * DVD(Digital Video Disc) ou CD(Compact Disc) - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface DVD_CDRepository extends JpaRepository<DVD_CD, Integer> {

}
