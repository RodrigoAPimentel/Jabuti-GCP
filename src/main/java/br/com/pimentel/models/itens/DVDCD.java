/**
 * 
 */
package br.com.pimentel.models.itens;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.pimentel.models.enums.Estado;
import br.com.pimentel.models.enums.ItemTipo;
import br.com.pimentel.models.enums.Status;

/**
 * DVD(Digital Video Disc) ou CD(Compact Disc)
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class DVDCD extends Item implements Serializable {

	private static final long serialVersionUID = -4493363084020458542L;
	
	@Column(length=50) private String marca;
	@Column(length=50) private String conteudo;
	
	public DVDCD() {
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
	 * @param quantidade Quantidade de Itens
	 * @param marca Marca do DVD(Digital Video Disc) ou CD(Compact Disc)
	 * @param conteudo Conteudo do DVD(Digital Video Disc) ou CD(Compact Disc)
	 */
	public DVDCD(String titulo, Double precoCompra, Double precoVenda, String observacoes,
			Estado estado, Status status, Integer quantidade, String marca, String conteudo) {
		super(ItemTipo.DVDCD, titulo, precoCompra, precoVenda, observacoes, estado, status, quantidade);
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
