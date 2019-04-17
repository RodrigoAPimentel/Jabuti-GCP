/**
 * 
 */
package br.com.pimentel.models.enums;

/**
 * Plataforma do Jogo
 * 
 * @author Rodrigo Pimentel
 */
public enum Plataforma {
	
	COMPUTADOR("Computador"),
	CONSOLE("Console (Video Game)");
	
	private String descricaoDePlataforma;

	/**
	 * @param descricaoDePlataforma Plataforma do Jogo
	 */
	private Plataforma(String descricaoDePlataforma) {
		this.descricaoDePlataforma = descricaoDePlataforma;
	}

	/**
	 * @return Plataforma do Jogo
	 */
	public String getDescricaoDePlataforma() {
		return descricaoDePlataforma;
	}
	
	

}
