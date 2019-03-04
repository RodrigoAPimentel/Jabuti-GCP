package br.com.pimentel.jabutigpc.model.itens;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.pimentel.jabutigpc.model.enums.Estado;
import br.com.pimentel.jabutigpc.model.enums.ItemTipo;
import br.com.pimentel.jabutigpc.model.enums.Status;

/**
 * Jogo de Tabuleiro
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class JogoDeTabuleiro extends Item implements Serializable {

	private static final long serialVersionUID = 8001977712896013621L;
	
	public JogoDeTabuleiro() {
		super();
	}

	/**
	 * Jogo de Tabuleiro
	 * 
	 * @param tipo Tipo do Item colecionavel
	 * @param titulo Titulo do Item colecionavel
	 * @param precoCompra Preço de Compra do Item colecionavel
	 * @param precoVenda Preço de Venda do Item colecionavel
	 * @param observacoes Observações
	 * @param estado Estado do Item colecionavel
	 * @param status Status do Item colecionavel
	 */
	public JogoDeTabuleiro(String titulo, Double precoCompra, Double precoVenda, String observacoes,
			Estado estado, Status status, String marca, String conteudo) {
		super(ItemTipo.TABULEIRO, titulo, precoCompra, precoVenda, observacoes, estado, status);
	} 
	
}
