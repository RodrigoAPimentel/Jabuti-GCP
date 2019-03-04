package br.com.pimentel.jabutigpc.test.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.jabutigpc.model.Endereco;
import br.com.pimentel.jabutigpc.model.Pessoa;

public class PessoaTest {
	
	private static Pessoa pessoa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pessoa = new Pessoa("000.000.000-00", "Rodrigo Pimentel", "Masculino", "Tio", null);
	}

	@Test
	public void testHashCode() {
		assertNotEquals(1, pessoa.hashCode());
	}

	@Test
	public void testGetSetCpf() {
		assertEquals("00000000000", pessoa.getCpf());
		pessoa.setCpf("111.111.111-11");
		assertEquals("11111111111", pessoa.getCpf());
	}

	@Test
	public void testGetSetNome() {
		assertEquals("Rodrigo Pimentel", pessoa.getNome());
		pessoa.setNome("Rodrigo de Almeida Pimentel");
		assertEquals("Rodrigo de Almeida Pimentel", pessoa.getNome());
	}

	@Test
	public void testGetSetSexo() {
		assertEquals("Masculino", pessoa.getSexo());
		pessoa.setSexo("Feminino");
		assertEquals("Feminino", pessoa.getSexo());
	}

	@Test
	public void testGetSetParentesco() {
		assertEquals("Tio", pessoa.getParentesco());
		pessoa.setParentesco("Avô");
		assertEquals("Avô", pessoa.getParentesco());
	}

	@Test
	public void testGetSetEndereco() {
		assertEquals(null, pessoa.getEndereco());
		pessoa.setEndereco(new Endereco());
		assertNotEquals(null, pessoa.getEndereco());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(pessoa, pessoa);
		assertNotEquals(new Pessoa(), pessoa);
	}

	@Test
	public void testToString() {
		assertEquals("Pessoa [cpf=00000000000, nome=Rodrigo de Almeida Pimentel, sexo=Feminino, "
				+ "parentesco=Avô, endereco=null]", pessoa.toString());
	}

}
