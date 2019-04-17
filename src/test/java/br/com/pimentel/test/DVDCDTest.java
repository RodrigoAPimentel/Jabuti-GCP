package br.com.pimentel.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.models.enums.Estado;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.DVDCD;

public class DVDCDTest {
	
	private static DVDCD dvdcd;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dvdcd = new DVDCD("Maria Betania", 38.0, 67.0, "Observação", Estado.NOVO, Status.NACOLECAO, 1, "Sony", "Musica");
	}

	@Test
	public void testGetSetMarca() {
		assertEquals("Sony", dvdcd.getMarca());
		dvdcd.setMarca("MGM");
		assertEquals("MGM", dvdcd.getMarca());
	}

	@Test
	public void testGetSetConteudo() {
		assertEquals("Musica", dvdcd.getConteudo());
		dvdcd.setConteudo("Show");
		assertEquals("Show", dvdcd.getConteudo());
	}

}
