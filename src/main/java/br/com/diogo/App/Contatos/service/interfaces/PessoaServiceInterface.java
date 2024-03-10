package br.com.diogo.App.Contatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.diogo.App.Contatos.dto.PessoaDTO;
import br.com.diogo.App.Contatos.model.Pessoa;




public interface PessoaServiceInterface {
	
	//Salvar o Pessoa
		Pessoa save(Pessoa Pessoa);
		//Recuperar 1 Pessoa
		Optional<Pessoa> getById(Long id);
		//Recuperar todos os Pessoas
		List<Pessoa> getAll();
		//Atualizar o Pessoa
		Pessoa update(Pessoa Pessoa);
		//Deletar o Pessoa
		void delete(Long id);
		
		List<PessoaDTO> buscaPessoas_Contatos();

}
