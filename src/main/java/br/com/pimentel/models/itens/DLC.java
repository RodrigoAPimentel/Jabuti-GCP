/**
 * 
 */
package br.com.pimentel.models.itens;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DLC(Downloadable Content)
 * 
 * @author Rodrigo Pimentel
 */
@Embeddable
public class DLC implements Serializable {
	
	private static final long serialVersionUID = 5739207653610807181L;
	
	@Column(length=50) private String tituloDLC;
	@Column(length=50) private String fonteDLC;
	
	public DLC() {
		super();
	}

	/**
	 * DLC(Downloadable Content)
	 * 
	 * @param titulo Titulo do DLC(Downloadable Content)
	 * @param fonte Fonte de instalação do DLC(Downloadable Content)
	 */
	public DLC(String tituloDLC, String fonteDLC) {
		super();
		this.tituloDLC = tituloDLC;
		this.fonteDLC = fonteDLC;
	}

	/**
	 * @return Titulo do DLC(Downloadable Content)
	 */
	public String getTituloDLC() {
		return tituloDLC;
	}

	/**
	 * @param titulo Titulo do DLC(Downloadable Content)
	 */
	public void setTituloDLC(String tituloDLC) {
		this.tituloDLC = tituloDLC;
	}

	/**
	 * @return Fonte de instalação do DLC(Downloadable Content)
	 */
	public String getFonteDLC() {
		return fonteDLC;
	}

	/**
	 * @param fonte Fonte de instalação do DLC(Downloadable Content)
	 */
	public void setFonteDLC(String fonte) {
		this.fonteDLC = fonte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fonteDLC == null) ? 0 : fonteDLC.hashCode());
		result = prime * result + ((tituloDLC == null) ? 0 : tituloDLC.hashCode());
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
		DLC other = (DLC) obj;
		if (fonteDLC == null) {
			if (other.fonteDLC != null)
				return false;
		} else if (!fonteDLC.equals(other.fonteDLC))
			return false;
		if (tituloDLC == null) {
			if (other.tituloDLC != null)
				return false;
		} else if (!tituloDLC.equals(other.tituloDLC))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DLC [titulo=" + tituloDLC + ", fonte=" + fonteDLC + "]";
	}
	
}
