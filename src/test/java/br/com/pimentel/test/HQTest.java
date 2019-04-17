package br.com.pimentel.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.pimentel.models.enums.Estado;
import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.enums.Status;
import br.com.pimentel.models.itens.HQ;

public class HQTest {

	private static HQ hq;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hq = new HQ("O Jabuti", 25.0, 29.90, "Teste de Observação", Estado.NOVO, Status.NACOLECAO, 1, 10, "Floresta", "Quelonios");
		hq.setCodigo(12345);
	}
	
	@Test
	public void testGetSetNumero() {
		assertEquals(10, hq.getNumero(),0.0);
		hq.setNumero(20);
		assertEquals(20, hq.getNumero(), 0.0);
	}

	@Test
	public void testGetSetEditora() {
		assertEquals("Floresta", hq.getEditora());
		hq.setEditora("Amazonia");
		assertEquals("Amazonia", hq.getEditora());
	}

	@Test
	public void testGetSetUniverso() {
		assertEquals("Quelonios", hq.getUniverso());
		hq.setUniverso("Tarta");
		assertEquals("Tarta", hq.getUniverso());
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(1, hq.hashCode());
	}

	@Test
	public void testGetSetCodigo() {
		assertEquals(12345, hq.getCodigo(),0.0);
		hq.setCodigo(67890);
		assertEquals(67890, hq.getCodigo(), 0.0);
	}

	@Test
	public void testGetSetTipo() {
		assertEquals(ItemTipo.HQ, hq.getTipo());
		assertEquals("História em quadrinhos", hq.getTipo().getDescricaoDeTipo());
		hq.setTipo(ItemTipo.TABULEIRO);
		assertEquals(ItemTipo.TABULEIRO, hq.getTipo());
		hq.setTipo(ItemTipo.HQ);
	}

	@Test
	public void testGetSetTitulo() {
		assertEquals("O Jabuti", hq.getTitulo());
		hq.setTitulo("O Jabuti Manco");
		assertEquals("O Jabuti Manco", hq.getTitulo());
	}

	@Test
	public void testGetSetPrecoCompra() {
		assertEquals(25.0, hq.getPrecoCompra(),0.0);
		hq.setPrecoCompra(26.0);
		assertEquals(26.0, hq.getPrecoCompra(),0.0);
	}

	@Test
	public void testGetSetPrecoVenda() {
		assertEquals(29.90, hq.getPrecoVenda(),0.0);
		hq.setPrecoVenda(36.0);
		assertEquals(36.0, hq.getPrecoVenda(),0.0);
	}
	
	@Test
	public void testGetSetObservacoes() {
		assertEquals("Teste de Observação", hq.getObservacoes());
		hq.setObservacoes("Teste 2");
		assertEquals("Teste 2", hq.getObservacoes());
	}

	@Test
	public void testGetSetEstado() {
		assertEquals(Estado.NOVO, hq.getEstado());
		assertEquals("Novo", hq.getEstado().getDescricaoDeEstado());
		hq.setEstado(Estado.RASGADO);
		assertEquals(Estado.RASGADO, hq.getEstado());
	}

	@Test
	public void testGetSetStatus() {
		assertEquals(Status.NACOLECAO, hq.getStatus());
		assertEquals("Em Coleção", hq.getStatus().getDescricaoDeStatus());
		hq.setStatus(Status.EMPRESTADO);
		assertEquals(Status.EMPRESTADO, hq.getStatus());
	}
	
	@Test
	public void testGetSetQuantidade() {
		assertEquals(1, hq.getQuantidade(),0.0);
		hq.setQuantidade(29);
		assertEquals(29, hq.getQuantidade(),0.0);
	}

	@Test
	public void testGetSetQuantidadedDeEmprestimos() {
		assertEquals(0, hq.getQuantidadeDeEmprestimos(),0.0);
		hq.setQuantidadeDeEmprestimos(29);
		assertEquals(29, hq.getQuantidadeDeEmprestimos(),0.0);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(hq, hq);
		assertNotEquals(new HQ(),  hq);
	}

	@Test
	public void testToString() {
		assertEquals("Item [codigo=12345, tipo=HQ, titulo=O Jabuti, precoCompra=25.0, "
						+ "precoVenda=36.0, observacoes=Teste de Observação, estado=NOVO, "
						+ "status=NACOLECAO, quantidadeDeEmprestimos=29, quantidade=1]", hq.toString());
	}

}
