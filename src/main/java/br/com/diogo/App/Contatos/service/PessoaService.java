package br.com.diogo.App.Contatos.service;



import java.util.ArrayList;
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

import br.com.diogo.App.Contatos.service.interfaces.PessoaServiceInterface;




@Service
public class PessoaService implements PessoaServiceInterface{



	private PessoaRepository pessoaRepository;
	private ContatoRepository contatoRepository;

	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository,  ContatoRepository contatoRepository) {
		this.pessoaRepository = pessoaRepository;
		this.contatoRepository = contatoRepository;
	}
	
	@Override
	public PessoaDTO save(PessoaDTO pessoaDTO) {		
		Pessoa pessoa = new Pessoa(pessoaDTO); 
		return  new PessoaDTO(pessoaRepository.save(pessoa));
	}

	@Override
	public Optional<PessoaDTO> getById(Long id) {		
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		PessoaDTO pessoaDTO = new PessoaDTO(pessoa.get());
		Optional<PessoaDTO> optPessoaDTO= Optional.of(pessoaDTO);
		return optPessoaDTO;		
	}

	@Override
	public List<PessoaDTO> getAll() {
		List<Pessoa> resultPessoas = pessoaRepository.findAll();
		List<PessoaDTO> pessoasDTO = new ArrayList<PessoaDTO>();
		for(Pessoa pessoa: resultPessoas) {
			PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
			List<Contato> contatos = contatoRepository.findById_pessoa(pessoa.getId());
			pessoaDTO.setContatos(contatos.stream().map(ContatoDTO::new).toList());
			
			pessoasDTO.add(pessoaDTO);
			
		}
		return pessoasDTO;
	}
	
	@Override
	public PessoaDTO update(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa(pessoaDTO);
		return new PessoaDTO(pessoaRepository.save(pessoa));		
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);		
	}


	
	
		
	
}
