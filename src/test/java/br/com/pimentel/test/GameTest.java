package br.com.pimentel.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.models.enums.Estado;
import br.com.pimentel.models.enums.Plataforma;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.DLC;
import br.com.pimentel.models.itens.Game;

public class GameTest {
	
	private static Game game;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		game = new Game("Jaba", 34.67, 58.90, "Observação", Estado.NOVO, Status.NACOLECAO, 1, "PS4", Plataforma.CONSOLE, false, null);
	}

	@Test
	public void testGetSetConsole() {
		assertEquals("PS4", game.getConsole());
		game.setConsole("XBox");
		assertEquals("XBox", game.getConsole());
	}

	@Test
	public void testGetSetPlataforma() {
		assertEquals(Plataforma.CONSOLE, game.getPlataforma());
		game.setPlataforma(Plataforma.COMPUTADOR);
		assertEquals("Computador", game.getPlataforma().getDescricaoDePlataforma());
		assertEquals(Plataforma.COMPUTADOR, game.getPlataforma());
	}

	@Test
	public void testGetSetZerado() {
		assertEquals(false, game.getZerado());
		game.setZerado(true);
		assertEquals(true, game.getZerado());
	}

	@Test
	public void testGetSetDlc() {
		assertEquals(null, game.getDlc());
		game.setDlc(new DLC());
		assertNotEquals(null, game.getDlc());
	}

}
