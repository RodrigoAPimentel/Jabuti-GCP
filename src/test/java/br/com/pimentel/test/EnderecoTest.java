package br.com.pimentel.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.models.Endereco;

public class EnderecoTest {

	private static Endereco endereco;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		endereco = new Endereco("58670-000", "Rua da Laje", 10, "Caixa D'Agua", "Campina Grande", "Paraiba",
				"Bloco GH, Apt 567", "Brasil", "(83) 99999-0000", "(83) 99999-1111", "(83) 99999-2222", "asdasd@sdf.sdf",
				null, "987676", "sdfsdfsdf.com.br", "Endereço teste");
	}

	@Test
	public void testHashCode() {
		assertNotEquals(1, endereco.hashCode());
	}

	@Test
	public void testGetSetCep() {
		assertEquals("58670000", endereco.getCep());
		endereco.setCep("58100000");
		assertEquals("58100000", endereco.getCep());
	}

	@Test
	public void testGetSetRua() {
		assertEquals("Rua da Laje", endereco.getRua());
		endereco.setRua("Rua do Tijolo");
		assertEquals("Rua do Tijolo", endereco.getRua());
	}

	@Test
	public void testGetSetNumero() {
		assertEquals(10, endereco.getNumero(),0.0);
		endereco.setNumero(11);
		assertEquals(11, endereco.getNumero(),0.0);
	}

	@Test
	public void testGetSetBairro() {
		assertEquals("Caixa D'Agua", endereco.getBairro());
		endereco.setBairro("Tambor");
		assertEquals("Tambor", endereco.getBairro());
	}

	@Test
	public void testGetSetCidade() {
		assertEquals("Campina Grande", endereco.getCidade());
		endereco.setCidade("Esperança");
		assertEquals("Esperança", endereco.getCidade());
	}

	@Test
	public void testGetSetEstado() {
		assertEquals("Paraiba", endereco.getEstado());
		endereco.setEstado("Pernambuco");
		assertEquals("Pernambuco", endereco.getEstado());
	}

	@Test
	public void testGetSetComplemento() {
		assertEquals("Bloco GH, Apt 567", endereco.getComplemento());
		endereco.setComplemento("casa B");
		assertEquals("casa B", endereco.getComplemento());
	}

	@Test
	public void testGetSetPais() {
		assertEquals("Brasil", endereco.getPais());
		endereco.setPais("Espanha");
		assertEquals("Espanha", endereco.getPais());
	}

	@Test
	public void testGetSetTelefones() {
		assertEquals("83999990000", endereco.getTelefone1());
		assertEquals("83999991111", endereco.getTelefone2());
		assertEquals("83999992222", endereco.getTelefone3());
		endereco.setTelefone1("83999997777");
		endereco.setTelefone2("83999998888");
		endereco.setTelefone3("83999999999");
		assertEquals("83999997777", endereco.getTelefone1());
		assertEquals("83999998888", endereco.getTelefone2());
		assertEquals("83999999999", endereco.getTelefone3());
	}
	
	@Test
	public void testGetSetEmails() {
		assertEquals("asdasd@sdf.sdf", endereco.getEmail1());
		assertEquals(null, endereco.getEmail2());
		endereco.setEmail1("njfvjsnaj@aefmc");
		endereco.setEmail2("m,xaLKDCUVN@asdfj");
		assertEquals("njfvjsnaj@aefmc", endereco.getEmail1());
		assertEquals("m,xaLKDCUVN@asdfj", endereco.getEmail2());
	}

	@Test
	public void testGetSetCaixaPostal() {
		assertEquals("987676", endereco.getCaixaPostal());
		endereco.setCaixaPostal("98147");
		assertEquals("98147", endereco.getCaixaPostal());
	}

	@Test
	public void testGetSetEnderecoWeb() {
		assertEquals("sdfsdfsdf.com.br", endereco.getEnderecoWeb());
		endereco.setEnderecoWeb("najdfnas.asdasd.ada");
		assertEquals("najdfnas.asdasd.ada", endereco.getEnderecoWeb());
	}

	@Test
	public void testGetSetObservacao() {
		assertEquals("Endereço teste", endereco.getObservacaoEndereco());
		endereco.setObservacaoEndereco("qualquer coisa");
		assertEquals("qualquer coisa", endereco.getObservacaoEndereco());
	}

	@Test
	public void testEqualsObject() {
		assertEquals(endereco, endereco);
		assertNotEquals(new Endereco(), endereco);
	}

	@Test
	public void testToString() {
		assertEquals(endereco.toString(), endereco.toString());
		assertNotEquals(new Endereco().toString(), endereco.toString());
	}

}
