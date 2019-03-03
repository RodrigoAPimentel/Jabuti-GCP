/**
 * 
 */
package br.com.pimentel.jabutigpc.model.itens;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.pimentel.jabutigpc.model.enums.Estado;
import br.com.pimentel.jabutigpc.model.enums.ItemTipo;
import br.com.pimentel.jabutigpc.model.enums.Status;

/**
 * @author Rodrigo Pimentel
 * 
 * Itens Colecionaveis
 *
 */
@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Item implements Serializable {

	private static final long serialVersionUID = 6671954236443484498L;

	@Id @Column(length=10)private Integer codigo;
	@Enumerated(EnumType.STRING) private ItemTipo tipo;
	@Column(length=50) private String titulo;
	@Column(length=20) private Double precoCompra;
	@Column(length=20) private Double precoVenda;
	@Column(length=200)private String observacoes;
	@Enumerated(EnumType.STRING) private Estado estado;
	@Enumerated(EnumType.STRING) private Status status;
	@Column(length=20) private Integer quantidadeDeEmprestimos;

	/** 
	 * Cria um Item Colecionavel
	 * 
	 * @param tipo Tipo do Item colecionavel
	 * @param titulo Titulo do Item colecionavel
	 * @param precoCompra Preço de Compra do Item colecionavel
	 * @param precoVenda Preço de Venda do Item colecionavel
	 * @param observacoes Observações
	 * @param estado Estado do Item colecionavel
	 * @param status Staus do Item colecionavel
	 */
	public Item(ItemTipo tipo, String titulo, Double precoCompra, Double precoVenda,String observacoes, Estado estado, 
			Status status) {
		super();
		this.tipo = tipo;
		this.titulo = titulo;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.observacoes = observacoes;
		this.estado = estado;
		this.status = status;
		this.quantidadeDeEmprestimos = 0;
	}
	
	/**
	 * @return Codigo do Item colecionavel
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @return Tipo do Item colecionavel
	 */
	public ItemTipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Tipo do Item colecionavel
	 */
	public void setTipo(ItemTipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return Titulo do Item colecionavel
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo Titulo do Item colecionavel
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return Preço de Compra do Item colecionavel
	 */
	public Double getPrecoCompra() {
		return precoCompra;
	}

	/**
	 * @param precoCompra Preço de Compra do Item colecionavel
	 */
	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	/**
	 * @return Preço de Venda do Item colecionavel
	 */
	public Double getPrecoVenda() {
		return precoVenda;
	}

	/**
	 * @param precoVenda Preço de Venda do Item colecionavel
	 */
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	/**
	 * @return Observações do Item colecionavel
	 */
	public String getObservacoes() {
		return observacoes;
	}

	/**
	 * @param observacoes Observações do Item colecionavel
	 */
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	/**
	 * @return Estado do Item colecionavel
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado Estado do Item colecionavel
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return Status do Item colecionavel
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status Status do Item colecionavel
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return Quantidade de vezes emprestado o Item colecionavel
	 */
	public Integer getQuantidadedDeEmprestimos() {
		return quantidadeDeEmprestimos;
	}

	/**
	 * @param quantidadedeEmprestimos Quantidade de vezes emprestado o Item colecionavel
	 */
	public void setQuantidadeDeEmprestimos(Integer quantidadeDeEmprestimos) {
		this.quantidadeDeEmprestimos = quantidadeDeEmprestimos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Item other = (Item) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", tipo=" + tipo + ", titulo=" + titulo + ", precoCompra=" + precoCompra
				+ ", precoVenda=" + precoVenda + ", observacoes=" + observacoes + ", estado=" + estado + ", status="
				+ status + ", quantidadeDeEmprestimos=" + quantidadeDeEmprestimos + "]";
	}
	
}
