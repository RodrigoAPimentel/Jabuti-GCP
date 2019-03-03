/**
 * 
 */
package br.com.pimentel.jabutigpc.model.itens;

import java.io.Serializable;

import br.com.pimentel.jabutigpc.model.enums.Estado;
import br.com.pimentel.jabutigpc.model.enums.ItemTipo;
import br.com.pimentel.jabutigpc.model.enums.Status;

/**
 * @author Rodrigo Pimentel
 * 
 * Historia em Quadrinhos
 *
 */
public class HQ extends Item implements Serializable {

	private static final long serialVersionUID = 6150291262821564241L;
	
	private Integer numero;
	private String editora;
	private String universo;
	
	/**
	 * Historia em Quadrinhos
	 * 
	 * @param tipo Tipo do Item colecionavel
	 * @param titulo Titulo do Item colecionavel
	 * @param precoCompra Preço de Compra do Item colecionavel
	 * @param precoVenda Preço de Venda do Item colecionavel
	 * @param observacoes Observações
	 * @param estado Estado do Item colecionavel
	 * @param status Staus do Item colecionavel
	 * @param numero Numero da Edição da Historia em Quadrinhos
	 * @param editora Editora da Historia em Quadrinhos
	 * @param universo Universo da Historia em Quadrinhos
	 */
	public HQ(String titulo, Double precoCompra, Double precoVenda, String observacoes, Estado estado,
			Status status, Integer numero, String editora, String universo) {
		super(ItemTipo.HQ, titulo, precoCompra, precoVenda, observacoes, estado, status);
		this.numero = numero;
		this.editora = editora;
		this.universo = universo;
	}

	/**
	 * @return Numero da Edição da Historia em Quadrinhos
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero Numero da Edição da Historia em Quadrinhos
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return Editora da Historia em Quadrinhos
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * @param editora Editora da Historia em Quadrinhos
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * @return Universo da Historia em Quadrinhos
	 */
	public String getUniverso() {
		return universo;
	}

	/**
	 * @param universo Universo da Historia em Quadrinhos
	 */
	public void setUniverso(String universo) {
		this.universo = universo;
	}	
	
}
