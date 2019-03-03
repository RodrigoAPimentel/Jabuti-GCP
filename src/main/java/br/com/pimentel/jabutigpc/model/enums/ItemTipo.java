/**
 * 
 */
package br.com.pimentel.jabutigpc.model.enums;

/**
 * @author Rodrigo Pimentel
 * 
 * Tipo de Itens Colecionaveis
 *
 */
public enum ItemTipo {

	HQ("história em quadrinhos"),
	DVDCD("DVD / CD"),
	GAMES("Jogos de Console ou Computador"),
	TABULEIRO("Jogos de Tabuleiro");
	
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
