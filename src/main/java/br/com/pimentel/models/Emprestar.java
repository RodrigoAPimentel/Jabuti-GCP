package br.com.pimentel.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.pimentel.models.itens.Item;

/**
 * Modela um Emprestimo de Item
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class Emprestar implements Serializable {

	private static final long serialVersionUID = -68972208594899217L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer codigoEmprestimo;
	@ManyToOne @JoinColumn(name = "cpf") private Usuario usuario;
	@ManyToOne @JoinColumn(name = "codigo") private Item item;
	@DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dataEmprestimo;
	@DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dataDevolucao;
	@DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate dataQueFoiDevolvido;
	private Boolean emprestado;
	
	/**
	 * Cria o Emprestimo de um Item
	 */
	public Emprestar() {
		super();
	}

	/**
	 * Cria o Emprestimo de um Item
	 * @param usuario Usuario que pegou o Item Emprestado
	 * @param item Item a ser emprestado
	 * @param dataEmprestimo Data do Emprestimo
	 * @param dataDevolucao Data a ser devolvido o Item
	 */
	public Emprestar(Usuario usuario, Item item, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		super();
		this.usuario = usuario;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * @return Codigo do Emprestimo
	 */
	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	/**
	 * @param codigo Codigo do Emprestimo
	 */
	public void setCodigoEmprestimo(Integer codigo) {
		this.codigoEmprestimo = codigo;
	}

	/**
	 * @return Usuario que pegou o Item Emprestado
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario Usuario que pegou o Item Emprestado
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return Item a ser emprestado
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item Item a ser emprestado
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return Data do Emprestimo
	 */
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * @param dataEmprestimo Data do Emprestimo
	 */
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * @return Data a ser devolvido o Item
	 */
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	/**
	 * @param dataDevolucao Data a ser devolvido o Item
	 */
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * @return Data que o Item foi devolvido
	 */
	public LocalDate getDataQueFoiDevolvido() {
		return dataQueFoiDevolvido;
	}

	/**
	 * @param dataQueFoiDevolvido Data que o Item foi devolvido
	 */
	public void setDataQueFoiDevolvido(LocalDate dataQueFoiDevolvido) {
		this.dataQueFoiDevolvido = dataQueFoiDevolvido;
	}

	/**
	 * @return Se TRUE o item esta emprestado se FALSE o item esta disponivel
	 */
	public Boolean getEmprestado() {
		return emprestado;
	}

	/**
	 * @param emprestado Se TRUE o item esta emprestado se FALSE o item esta disponivel
	 */
	public void setEmprestado(Boolean emprestado) {
		this.emprestado = emprestado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEmprestimo == null) ? 0 : codigoEmprestimo.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestar other = (Emprestar) obj;
		if (codigoEmprestimo == null) {
			if (other.codigoEmprestimo != null)
				return false;
		} else if (!codigoEmprestimo.equals(other.codigoEmprestimo))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestar [codigoEmprestimo=" + codigoEmprestimo + ", usuario=" + usuario + ", item=" + item
				+ ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", dataQueFoiDevolvido="
				+ dataQueFoiDevolvido + ", emprestado=" + emprestado + "]";
	}

}
