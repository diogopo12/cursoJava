package br.com.diogo.App.Contatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.diogo.App.Contatos.dto.ContatoDTO;



public interface ContatoServiceInterface {
	
		
			ContatoDTO save(ContatoDTO contato);
		
			Optional<ContatoDTO> getById(Long id);
		
			List<ContatoDTO> getAll();
		
			ContatoDTO update(ContatoDTO contatoDTO);
		
			void delete(Long id);		
			


}
