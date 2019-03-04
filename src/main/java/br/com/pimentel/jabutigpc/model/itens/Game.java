package br.com.pimentel.jabutigpc.model.itens;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.pimentel.jabutigpc.model.enums.Estado;
import br.com.pimentel.jabutigpc.model.enums.ItemTipo;
import br.com.pimentel.jabutigpc.model.enums.Plataforma;
import br.com.pimentel.jabutigpc.model.enums.Status;

/**
 * Jogo de Console ou Computador
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class Game extends Item implements Serializable {

	private static final long serialVersionUID = 6619019481403142625L;
	
	@Column(length=50) private String console;
	@Enumerated(EnumType.STRING) private Plataforma plataforma;
	private Boolean zerado;
	@Embedded private DLC dlc;
	
	public Game() {
		super();
	}

	/**
	 * Jogo de Console ou Computador
	 * 
	 * @param tipo Tipo do Item colecionavel
	 * @param titulo Titulo do Item colecionavel
	 * @param precoCompra Preço de Compra do Item colecionavel
	 * @param precoVenda Preço de Venda do Item colecionavel
	 * @param observacoes Observações
	 * @param estado Estado do Item colecionavel
	 * @param status Status do Item colecionavel
	 * @param console Console do Jogo 
	 * @param plataforma Plataforma do Jogo
	 * @param zerado Jogo de Console ou Computador ja foi zerado
	 * @param dlc Se possui DLC e qual
	 */
	public Game(String titulo, Double precoCompra, Double precoVenda, String observacoes, Estado estado,
			Status status, String console, Plataforma plataforma, Boolean zerado, DLC dlc) {
		super(ItemTipo.GAMES, titulo, precoCompra, precoVenda, observacoes, estado, status);
		this.console = console;
		this.plataforma = plataforma;
		this.zerado = zerado;
		this.dlc = dlc;
	}

	/**
	 * @return Console do Jogo 
	 */
	public String getConsole() {
		return console;
	}

	/**
	 * @param console Console do Jogo 
	 */
	public void setConsole(String console) {
		this.console = console;
	}

	/**
	 * @return Plataforma do Jogo
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma Plataforma do Jogo
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * @return Jogo de Console ou Computador ja foi zerado
	 */
	public Boolean getZerado() {
		return zerado;
	}

	/**
	 * @param zerado Jogo de Console ou Computador ja foi zerado
	 */
	public void setZerado(Boolean zerado) {
		this.zerado = zerado;
	}

	/**
	 * @return Se possui DLC e qual
	 */
	public DLC getDlc() {
		return dlc;
	}

	/**
	 * @param dlc Se possui DLC e qual
	 */
	public void setDlc(DLC dlc) {
		this.dlc = dlc;
	}

}
