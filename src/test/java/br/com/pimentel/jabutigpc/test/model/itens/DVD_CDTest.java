package br.com.pimentel.jabutigpc.test.model.itens;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.jabutigpc.model.enums.Estado;
import br.com.pimentel.jabutigpc.model.enums.Status;
import br.com.pimentel.jabutigpc.model.itens.DVD_CD;

public class DVD_CDTest {
	
	private static DVD_CD dvd_cd;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dvd_cd = new DVD_CD("Maria Betania", 38.0, 67.0, "Observação", Estado.NOVO, Status.NACOLECAO, "Sony", "Musica");
	}

	@Test
	public void testGetSetMarca() {
		assertEquals("Sony", dvd_cd.getMarca());
		dvd_cd.setMarca("MGM");
		assertEquals("MGM", dvd_cd.getMarca());
	}

	@Test
	public void testGetSetConteudo() {
		assertEquals("Musica", dvd_cd.getConteudo());
		dvd_cd.setConteudo("Show");
		assertEquals("Show", dvd_cd.getConteudo());
	}

}
