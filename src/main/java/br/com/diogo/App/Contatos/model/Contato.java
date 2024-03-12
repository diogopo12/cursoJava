package br.com.diogo.App.Contatos.model;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.diogo.App.Contatos.dto.ContatoDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTATOS")
public class Contato {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TIPOCONTATO", nullable = false)
	private Integer tipoContato;
	
	@Column(name = "contato", nullable = false)
	private String contato;
	

	@ManyToOne //(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa")//, insertable=false, updatable=false)
	private Pessoa pessoa;
	
	public Contato() {}

	public Contato(ContatoDTO contatoDTO) {
		BeanUtils.copyProperties(contatoDTO, this);
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 0 - Telefone
	 * 1 - Celular
	 * 2 - E-mail
	 * 3 - Rede social
	 */
	public Integer getTipoContato() {
		return tipoContato;
	}

	/**
	 * 0 - Telefone
	 * 1 - Celular
	 * 2 - E-mail
	 * 3 - Rede social
	 */
	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
