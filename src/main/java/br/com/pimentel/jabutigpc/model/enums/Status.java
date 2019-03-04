/**
 * 
 */
package br.com.pimentel.jabutigpc.model.enums;

/**
 * Status de Itens Colecionaveis
 * 
 * @author Rodrigo Pimentel
 */
public enum Status {
	
	NACOLECAO("Em Coleção"),
	EMPRESTADO("Emprestado"),
	VENDIDO("Vendido"),
	PARAVENDER("Disponivel para venda"),
	NAOEMPRESTAVEL("Não disponivel para emprestimo"),
	DESEJAVEL("Desejavel"),
	AVARIADO("Avariado"),
	EMREPARO("Em reparo");
	
	private String descricaoDeStatus;

	/**
	 * @param descricaoDeStatus Status do Itens Colecionavel
	 */
	private Status(String descricaoDeStatus) {
		this.descricaoDeStatus = descricaoDeStatus;
	}

	/**
	 * @return Status do Itens Colecionavel
	 */
	public String getDescricaoDeStatus() {
		return descricaoDeStatus;
	}
	
}
