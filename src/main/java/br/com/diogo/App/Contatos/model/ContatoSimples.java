package br.com.diogo.App.Contatos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTATOS")
public class ContatoSimples {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TIPOCONTATO", nullable = false)
	private Integer tipoContato;
	
	@Column(name = "contato", nullable = false)
	private String contato;
	
	@Column(name = "id_pessoa", nullable = false)
	private Long id_pessoa;
	
	public ContatoSimples() {}

	public ContatoSimples(Long id, Integer tipoContato, String contato, Long id_pessoa) {
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.id_pessoa = id_pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	

}
