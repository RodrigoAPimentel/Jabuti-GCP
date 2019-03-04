/**
 * 
 */
package br.com.pimentel.jabutigpc.model.enums;

/**
 * Plataforma do Jogo
 * 
 * @author Rodrigo Pimentel
 */
public enum Plataforma {
	
	CONSOLE("Console (Video Game)"),
	COMPUTADOR("Computador");
	
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
