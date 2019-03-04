/**
 * 
 */
package br.com.pimentel.jabutigpc.model.enums;

/**
 * Tipo de Itens Colecionaveis
 * 
 * @author Rodrigo Pimentel
 */
public enum ItemTipo {

	HQ("história em quadrinhos"),
	DVDCD("DVD(Digital Video Disc) ou CD(Compact Disc)"),
	GAMES("Jogo de Console ou Computador"),
	TABULEIRO("Jogo de Tabuleiro");
	
	private String descricaoDeTipo;

	/**
	 * @param descricaoDeTipo Tipo do Item Colecionavel
	 */
	private ItemTipo(String descricaoDeTipo) {
		this.descricaoDeTipo = descricaoDeTipo;
	}

	/**
	 * @return Tipo do Item Colecionavel
	 */
	public String getDescricaoDeTipo() {
		return descricaoDeTipo;
	}
	
}
