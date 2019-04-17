package br.com.pimentel.repositories.itens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pimentel.models.itens.DVDCD;

/**
 * DVD(Digital Video Disc) ou CD(Compact Disc) - Data Access Object(DAO)
 * 
 * @author Rodrigo Pimentel
 */
@Repository
public interface DVDCDRepository extends JpaRepository<DVDCD, Integer> {

}
