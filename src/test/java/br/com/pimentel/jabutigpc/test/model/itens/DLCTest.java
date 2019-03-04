package br.com.pimentel.jabutigpc.test.model.itens;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.jabutigpc.model.itens.DLC;

public class DLCTest {
	
	private static DLC dlc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dlc = new DLC("A Revolta", "Steam");
	}

	@Test
	public void testHashCode() {
		assertNotEquals(1, dlc.hashCode());
	}

	@Test
	public void testGetSetTitulo() {
		assertEquals("A Revolta", dlc.getTituloDLC());
		dlc.setTituloDLC("A Revolta 2");
		assertEquals("A Revolta 2", dlc.getTituloDLC());
	}

	@Test
	public void testGetSetFonte() {
		assertEquals("Steam", dlc.getFonteDLC());
		dlc.setFonteDLC("Live");
		assertEquals("Live", dlc.getFonteDLC());
	}

	@Test
	public void testEqualsObject() {
		assertNotEquals(new DLC(), dlc);
		assertEquals(dlc, dlc);
	}

	@Test
	public void testToString() {
		assertEquals("DLC [titulo=A Revolta, fonte=Live]", dlc.toString());
	}

}
