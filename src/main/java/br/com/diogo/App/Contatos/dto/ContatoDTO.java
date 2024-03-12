package br.com.diogo.App.Contatos.dto;

import org.springframework.beans.BeanUtils;

import br.com.diogo.App.Contatos.model.Contato;
import br.com.diogo.App.Contatos.model.Pessoa;
import br.com.diogo.App.Contatos.dto.PessoaDTO;


public class ContatoDTO {
	
	
	private Long id;
	private Integer tipoContato;
	private String contato;
	private Long id_pessoa;
	
	
	public ContatoDTO() {}
	
	public ContatoDTO(Contato contato) {
		BeanUtils.copyProperties(contato, this);
		if(contato != null && contato.getPessoa() != null) {
			this.setId_pessoa(contato.getPessoa().getId());		
		}
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
