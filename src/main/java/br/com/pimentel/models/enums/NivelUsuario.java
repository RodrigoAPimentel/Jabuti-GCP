package br.com.pimentel.models.enums;

/**
 * Nivel de Usuario
 * 
 * @author Rodrigo Pimentel
 */
public enum NivelUsuario {
	
	ADMIN("Administrador"),
	USER("Usuario Comum");
	
	private String descricaoNivelUsuario;

	/**
	 * @param descricaoNivelUsuario Descrição do Nivel de Usuario
	 */
	private NivelUsuario(String descricaoNivelUsuario) {
		this.descricaoNivelUsuario = descricaoNivelUsuario;
	}

	/**
	 * @return Descrição do Nivel de Usuario
	 */
	public String getDescricaoNivelUsuario() {
		return descricaoNivelUsuario;
	}
	
}
