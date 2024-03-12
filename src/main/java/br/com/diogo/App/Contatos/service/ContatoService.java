package br.com.diogo.App.Contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diogo.App.Contatos.dto.ContatoDTO;
import br.com.diogo.App.Contatos.dto.PessoaDTO;
import br.com.diogo.App.Contatos.model.Contato;
import br.com.diogo.App.Contatos.model.Pessoa;
import br.com.diogo.App.Contatos.repository.ContatoRepository;
import br.com.diogo.App.Contatos.repository.PessoaRepository;
import br.com.diogo.App.Contatos.service.interfaces.ContatoServiceInterface;



@Service
public class ContatoService implements ContatoServiceInterface {
		
		
	private ContatoRepository contatoRepository;
	private PessoaRepository pessoaRepository;


	@Autowired
	public ContatoService(ContatoRepository contatoRepository,PessoaRepository pessoaRepository) {
		this.contatoRepository = contatoRepository;
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public ContatoDTO save(ContatoDTO contatoDTO) {
		Contato contato = new Contato(contatoDTO); 
		Optional<Pessoa> optPessoa = pessoaRepository.findById(contatoDTO.getId_pessoa());
		if (optPessoa.isPresent()) {
			contato.setPessoa(optPessoa.get());
		}
		
		return  new ContatoDTO(contatoRepository.save(contato));
	}


	
	@Override
	public Optional<ContatoDTO> getById(Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		ContatoDTO contatoDTO = new ContatoDTO(contato.get());
		Optional<ContatoDTO> optContatoDTO= Optional.of(contatoDTO);
		return optContatoDTO;		

	}

	@Override
	public List<ContatoDTO> getAll() {
		List<Contato> resultContatos = contatoRepository.findAll();		
		return resultContatos.stream().map(ContatoDTO::new).toList();		
	}

	@Override
	public ContatoDTO update(ContatoDTO contatoDTO) {
		Contato contato = new Contato(contatoDTO);
		Optional<Pessoa> optPessoa = pessoaRepository.findById(contatoDTO.getId_pessoa());
		if (optPessoa.isPresent()) {
			contato.setPessoa(optPessoa.get());
		}
		return new ContatoDTO(contatoRepository.save(contato));
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);		
		
	}


	

	

}
