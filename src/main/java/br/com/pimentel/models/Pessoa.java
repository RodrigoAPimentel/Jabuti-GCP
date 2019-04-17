package br.com.pimentel.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Modela uma Pessoa Fisica
 * 
 * @author Rodrigo Pimentel
 */
@Entity @Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 4465293115845409676L;

	@Id @Column(length=11) private String cpf;
	@Column(length=50) private String nome;
	@Column(length=50) private String sexo;	
	@OneToOne(cascade=CascadeType.ALL) private Endereco endereco;
	
	/**
	 * Pessoa Fisica
	 */
	public Pessoa() {
		super();
	}

	/**
	 * Pessoa Fisica
	 * 
	 * @param cpf Numero do Cadastro de Pessoa Fisica (CPF)
	 * @param nome Nome completo
	 * @param sexo Sexo
	 * @param endereco Endereço
	 */
	public Pessoa(String cpf, String nome, String sexo, Endereco endereco) {
		super();
		this.cpf = cpf.replaceAll("[^0-9]", "");
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	/**
	 * @return Numero do Cadastro de Pessoa Fisica (CPF)
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf Numero do Cadastro de Pessoa Fisica (CPF)
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[^0-9]", "");
	}

	/**
	 * @return Nome completo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome Nome completo
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo Sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * @return Endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco Endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
