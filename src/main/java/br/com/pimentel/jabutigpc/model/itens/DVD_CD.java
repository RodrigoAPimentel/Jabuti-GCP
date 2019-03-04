/**
 * 
 */
package br.com.pimentel.jabutigpc.model.itens;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.pimentel.jabutigpc.model.enums.Estado;
import br.com.pimentel.jabutigpc.model.enums.ItemTipo;
import br.com.pimentel.jabutigpc.model.enums.Status;

/**
 * DVD(Digital Video Disc) ou CD(Compact Disc)
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class DVD_CD extends Item implements Serializable {

	private static final long serialVersionUID = -4493363084020458542L;
	
	@Column(length=50) private String marca;
	@Column(length=50) private String conteudo;
	
	public DVD_CD() {
		super();
	}

	/**
	 * DVD(Digital Video Disc) ou CD(Compact Disc)
	 * 
	 * @param tipo Tipo do Item colecionavel
	 * @param titulo Titulo do Item colecionavel
	 * @param precoCompra Preço de Compra do Item colecionavel
	 * @param precoVenda Preço de Venda do Item colecionavel
	 * @param observacoes Observações
	 * @param estado Estado do Item colecionavel
	 * @param status Status do Item colecionavel
	 * @param marca Marca do DVD(Digital Video Disc) ou CD(Compact Disc)
	 * @param conteudo Conteudo do DVD(Digital Video Disc) ou CD(Compact Disc)
	 */
	public DVD_CD(String titulo, Double precoCompra, Double precoVenda, String observacoes,
			Estado estado, Status status, String marca, String conteudo) {
		super(ItemTipo.DVDCD, titulo, precoCompra, precoVenda, observacoes, estado, status);
		this.marca = marca;
		this.conteudo = conteudo;
	}

	/**
	 * @return Marca do DVD(Digital Video Disc) ou CD(Compact Disc)
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca Marca do DVD(Digital Video Disc) ou CD(Compact Disc)
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return Conteudo do DVD(Digital Video Disc) ou CD(Compact Disc)
	 */
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo Conteudo do DVD(Digital Video Disc) ou CD(Compact Disc)
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
