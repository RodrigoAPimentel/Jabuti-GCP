/**
 * 
 */
package br.com.pimentel.jabutigpc.model.enums;

/**
 * Estado de Itens Colecionaveis
 * 
 * @author Rodrigo Pimentel
 */
public enum Estado {

	NOVO("Novo"),
	AMASSADO("Amassado"),
	RASGADO("Rasgado"),
	RISCADO("Riscado"),
	ARRANHADO("Arranhado"), 
	QUEBRADO("Quebrado"),
	FALTANDOPECA("Faltando Peça");
	
	private String descricaoDeEstado;
	
	/**
	 * @param descricaoDeEstado Descrição do estado de Uso do Item
	 */
	private Estado(String descricaoDeEstado) {
		this.descricaoDeEstado = descricaoDeEstado;
	}

	/**
	 * @return Descrição do estado de Uso do Item
	 */
	public String getDescricaoDeEstado() {
		return descricaoDeEstado;
	}
	
}
