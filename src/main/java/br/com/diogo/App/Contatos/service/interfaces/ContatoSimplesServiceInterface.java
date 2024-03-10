package br.com.diogo.App.Contatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.diogo.App.Contatos.model.ContatoSimples;

public interface ContatoSimplesServiceInterface {

	ContatoSimples save(ContatoSimples contato);
	//Recuperar 1 ContatoSimples
	Optional<ContatoSimples> getById(Long id);
	//Recuperar todos os ContatoSimpless
	List<ContatoSimples> getAll();
	//Atualizar o ContatoSimples
	ContatoSimples update(ContatoSimples ContatoSimples);
	//Deletar o ContatoSimples
	void delete(Long id);
}
