/**
 * 
 */
package br.com.pimentel.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Endereço
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = -9151474872475626285L;
	
	private static final String RETIRAPONTOS = "[^0-9]";
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(length=8) private Integer id;
	@Column(length=8) private String cep;
	@Column(length=50) private String rua;
	@Column(length=6) private Integer numero;
	@Column(length=20) private String bairro;
	@Column(length=20) private String cidade;
	@Column(length=20) private String estado;
	@Column(length=30) private String complemento;
	@Column(length=20) private String pais;
	@Column(length=15) private String telefone1;
	@Column(length=15) private String telefone2;
	@Column(length=15) private String telefone3;
	@Column(length=25) private String email1;
	@Column(length=25) private String email2;
	@Column(length=15) private String caixaPostal;
	@Column(length=30) private String enderecoWeb;
	@Column(length=150) private String observacaoEndereco;

	public Endereco() {
		super();
	}

	/**
	 * Endereço
	 * 
	 * @param cep Numero do CEP
	 * @param rua Nome da Rua
	 * @param numero Numero do domicilio
	 * @param bairro Bairro
	 * @param cidade Cidade
	 * @param estado Estado
	 * @param complemento Complemento ao endereço
	 * @param pais Pais
	 * @param telefone1 Primeiro numero de telefone
	 * @param telefone2 Segundo numero de telefone
	 * @param telefone3 Terceiro numero de telefone
	 * @param email1 Primeiro Email
	 * @param email2Segundo Emal
	 * @param caixaPostal Caixa Postal
	 * @param enderecoWeb URL do site 
	 * @param observacaoEndereco observações
	 */
	public Endereco(String cep, String rua, Integer numero, String bairro, String cidade, String estado,
			String complemento, String pais, String telefone1, String telefone2, String telefone3, String email1,
			String email2, String caixaPostal, String enderecoWeb, String observacaoEndereco) {
		super();
		this.cep = cep.replaceAll(RETIRAPONTOS, "");
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.pais = pais;
		this.telefone1 = telefone1.replaceAll(RETIRAPONTOS, "");
		this.telefone2 = telefone2.replaceAll(RETIRAPONTOS, "");
		this.telefone3 = telefone3.replaceAll(RETIRAPONTOS, "");
		this.email1 = email1;
		this.email2 = email2;
		this.caixaPostal = caixaPostal.replaceAll(RETIRAPONTOS, "");
		this.enderecoWeb = enderecoWeb;
		this.observacaoEndereco = observacaoEndereco;
	}

	/**
	 * @return ID do Endereço
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return Numero do CEP
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep Numero do CEP
	 */
	public void setCep(String cep) {
		this.cep = cep.replaceAll(RETIRAPONTOS, "");
	}

	/** 
	 * @return Nome da Rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua Nome da Rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return Numero do Imovel
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero Numero do Imovel
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return Bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro Bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return Cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade Cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return Estado da Federação
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado Estado da Federação
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return Complemento ao Endereço
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento Complemento ao Endereço
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return Pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais Pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return 1º numero de telefone
	 */
	public String getTelefone1() {
		return telefone1;
	}

	/**
	 * @param telefone1 1º numero de telefone
	 */
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1.replaceAll(RETIRAPONTOS, "");
	}

	/**
	 * @return 2º numero de telefone
	 */
	public String getTelefone2() {
		return telefone2;
	}

	/**
	 * @param telefone2 2º numero de telefone
	 */
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2.replaceAll(RETIRAPONTOS, "");
	}

	/**
	 * @return 3º numero de telefone
	 */
	public String getTelefone3() {
		return telefone3;
	}

	/**
	 * @param telefone3 3º numero de telefone
	 */
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3.replaceAll(RETIRAPONTOS, "");
	}

	/**
	 * @return 1º endereço de E-Mail
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @param email1 1º endereço de E-Mail
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/**
	 * @return 2º endereço de E-Mail
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2 2º endereço de E-Mail
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * @return Endereço da Caixa Postal
	 */
	public String getCaixaPostal() {
		return caixaPostal;
	}

	/**
	 * @param caixaPostal Endereço da Caixa Postal
	 */
	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal.replaceAll(RETIRAPONTOS, "");
	}

	/**
	 * @return Endereço WEB(URL)
	 */
	public String getEnderecoWeb() {
		return enderecoWeb;
	}

	/**
	 * @param enderecoWeb Endereço WEB(URL)
	 */
	public void setEnderecoWeb(String enderecoWeb) {
		this.enderecoWeb = enderecoWeb;
	}
	
	/**
	 * @return Observações
	 */
	public String getObservacaoEndereco() {
		return observacaoEndereco;
	}

	/**
	 * @param observacao Observações
	 */
	public void setObservacaoEndereco(String observacaoEndereco) {
		this.observacaoEndereco = observacaoEndereco;
	}	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnderecoImpl [cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", complemento=" + complemento + ", pais=" + pais + ", telefone1="
				+ telefone1 + ", telefone2=" + telefone2 + ", telefone3=" + telefone3 + ", email1=" + email1
				+ ", email2=" + email2 + ", caixaPostal=" + caixaPostal + ", enderecoWeb=" + enderecoWeb
				+ ", observacaoEndereco=" + observacaoEndereco + "]";
	}

}
