package br.com.pimentel.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import br.com.pimentel.models.enums.NivelUsuario;

/**
 * Modela uma Usuario
 * 
 * @author Rodrigo Pimentel
 */
@Entity
public class Usuario extends Pessoa implements Serializable {

	private static final long serialVersionUID = -8825985463761424080L;
	
	@Column(length=50) private String parentesco;
	@Enumerated(EnumType.STRING) private NivelUsuario nivelUsuario;	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE) private List<Emprestar> emprestimos;
	
	/**
	 * Cria um Usuario
	 */
	public Usuario() {
		super();
	}

	/**
	 * Cria um Usuario
	 * @param cpf Numero do Cadastro de Pessoa Fisica (CPF)
	 * @param nome Nome completo
	 * @param sexo Sexo
	 * @param endereco Endereço
	 * @param parentesco Nivel de Parentesco do Usuario com o proprietario
	 * @param nivelUsuario Nivel de perimssão do Usuario
	 */
	public Usuario(String cpf, String nome, String sexo, Endereco endereco, String parentesco,
			NivelUsuario nivelUsuario) {
		super(cpf, nome, sexo, endereco);
		this.parentesco = parentesco;
		this.nivelUsuario = nivelUsuario;
	}

	/**
	 * @return Nivel de Parentesco do Usuario com o proprietario
	 */
	public String getParentesco() {
		return parentesco;
	}

	/**
	 * @param parentesco Nivel de Parentesco do Usuario com o proprietario
	 */
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	/**
	 * @return Nivel de perimssão do Usuario
	 */
	public NivelUsuario getNivelUsuario() {
		return nivelUsuario;
	}

	/**
	 * @param nivelUsuario Nivel de perimssão do Usuario
	 */
	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	/**
	 * @return Lista de emprestimos
	 */
	public List<Emprestar> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * @param emprestimos Lista de emprestimos
	 */
	public void setEmprestimos(List<Emprestar> emprestimos) {
		this.emprestimos = emprestimos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nivelUsuario == null) ? 0 : nivelUsuario.hashCode());
		result = prime * result + ((parentesco == null) ? 0 : parentesco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nivelUsuario != other.nivelUsuario)
			return false;
		if (parentesco == null) {
			if (other.parentesco != null)
				return false;
		} else if (!parentesco.equals(other.parentesco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [parentesco=" + parentesco + ", nivelUsuario=" + nivelUsuario + ", emprestimos=" + emprestimos
				+ "]";
	}
	
}
