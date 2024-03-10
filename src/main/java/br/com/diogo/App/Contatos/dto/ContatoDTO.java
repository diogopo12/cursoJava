package br.com.diogo.App.Contatos.dto;

public class ContatoDTO {
	
	private Long id;
	private Integer tipoContato;
	private String contato;
	private Long id_pessoa;
	
	public ContatoDTO() {}
	
	public ContatoDTO(Long id,Integer tipocontato,String contato,Long id_pessoa) {
		this.id=id;
		this.tipoContato=tipocontato;
		this.contato=contato;
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
