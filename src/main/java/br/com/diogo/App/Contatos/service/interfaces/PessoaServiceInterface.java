package br.com.diogo.App.Contatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.diogo.App.Contatos.dto.PessoaDTO;


public interface PessoaServiceInterface {
	
	//Salvar o PessoaDTO
		PessoaDTO save(PessoaDTO pessoaDTO);
		//Recuperar 1 PessoaDTO
		Optional<PessoaDTO> getById(Long id);
		//Recuperar todos os PessoaDTOs
		List<PessoaDTO> getAll();
		//Atualizar o PessoaDTO
		PessoaDTO update(PessoaDTO PessoaDTO);
		//Deletar o PessoaDTO
		void delete(Long id);
		

}
