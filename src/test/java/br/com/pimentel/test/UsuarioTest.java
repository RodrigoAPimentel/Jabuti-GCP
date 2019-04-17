package br.com.pimentel.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.models.Endereco;
import br.com.pimentel.models.Usuario;
import br.com.pimentel.models.enums.NivelUsuario;

public class UsuarioTest {
	
	private static Usuario usuario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario = new Usuario("000.000.000-00", "Rodrigo Pimentel", "Masculino", null, "Tio", NivelUsuario.ADMIN);
	}

	@Test
	public void testHashCode() {
		assertNotEquals(1, usuario.hashCode());
	}

	@Test
	public void testGetSetCpf() {
		assertEquals("00000000000", usuario.getCpf());
		usuario.setCpf("111.111.111-11");
		assertEquals("11111111111", usuario.getCpf());
	}

	@Test
	public void testGetSetNome() {
		assertEquals("Rodrigo Pimentel", usuario.getNome());
		usuario.setNome("Rodrigo de Almeida Pimentel");
		assertEquals("Rodrigo de Almeida Pimentel", usuario.getNome());
	}

	@Test
	public void testGetSetSexo() {
		assertEquals("Masculino", usuario.getSexo());
		usuario.setSexo("Feminino");
		assertEquals("Feminino", usuario.getSexo());
	}

	@Test
	public void testGetSetParentesco() {
		assertEquals("Tio", usuario.getParentesco());
		usuario.setParentesco("Avô");
		assertEquals("Avô", usuario.getParentesco());
	}

	@Test
	public void testGetSetEndereco() {
		assertEquals(null, usuario.getEndereco());
		usuario.setEndereco(new Endereco());
		assertNotEquals(null, usuario.getEndereco());
	}
	
	@Test
	public void testGetSetNivelUsuario() {
		assertEquals(NivelUsuario.ADMIN, usuario.getNivelUsuario());
		assertEquals("Administrador", usuario.getNivelUsuario().getDescricaoNivelUsuario());
		usuario.setNivelUsuario(NivelUsuario.USER);
		assertEquals(NivelUsuario.USER, usuario.getNivelUsuario());
		usuario.setNivelUsuario(NivelUsuario.ADMIN);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(usuario, usuario);
		assertNotEquals(new Usuario(), usuario);
	}

	@Test
	public void testToString() {
		assertEquals("Usuario [parentesco=Avô, nivelUsuario=ADMIN, emprestimos=null]", usuario.toString());
	}

}
