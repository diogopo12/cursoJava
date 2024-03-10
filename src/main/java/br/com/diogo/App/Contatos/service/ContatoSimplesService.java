package br.com.diogo.App.Contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diogo.App.Contatos.model.ContatoSimples;
import br.com.diogo.App.Contatos.repository.ContatoSimplesRepository;
import br.com.diogo.App.Contatos.service.interfaces.ContatoSimplesServiceInterface;




@Service
public class ContatoSimplesService implements ContatoSimplesServiceInterface {
		
		
	private ContatoSimplesRepository contato_Repository;


	@Autowired
	public ContatoSimplesService(ContatoSimplesRepository contato_Repository) {
		this.contato_Repository = contato_Repository;

	}
	
	@Override
	public ContatoSimples save(ContatoSimples contato) {
		return contato_Repository.save(contato);
	}


	
	@Override
	public Optional<ContatoSimples> getById(Long id) {
		return contato_Repository.findById(id);

	}

	@Override
	public List<ContatoSimples> getAll() {
		return contato_Repository.findAll();
	}

	@Override
	public ContatoSimples update(ContatoSimples contato) {
		Optional<ContatoSimples> findContatoSimples = contato_Repository.findById(contato.getId());
				
				//se ele existir, vou atualizar:
				if(findContatoSimples.isPresent()) {
					ContatoSimples updateContatoSimples = findContatoSimples.get(); //setId
					updateContatoSimples.setTipoContato(contato.getTipoContato());
					updateContatoSimples.setContato(contato.getContato());
					updateContatoSimples.setId_pessoa(contato.getId_pessoa());	
					return contato_Repository.save(updateContatoSimples);
				}
				return contato;		
	}

	@Override
	public void delete(Long id) {
		contato_Repository.deleteById(id);		
		
	}


	

	

}
