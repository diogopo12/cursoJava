package br.com.diogo.App.Contatos.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Optional<Pessoa> getById(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}
	
	@Override
	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		//se ele existir, vou atualizar:
		if(findPessoa.isPresent()) {
			Pessoa updatePessoa = findPessoa.get(); //setId
			updatePessoa.setNome(pessoa.getNome());
			updatePessoa.setEndereco(pessoa.getEndereco());
			updatePessoa.setCidade(pessoa.getCidade());
			updatePessoa.setUf(pessoa.getUf());
			updatePessoa.setCep(pessoa.getCep());
			return pessoaRepository.save(updatePessoa);			
		}
		return pessoa;		
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);		
	}
	
	@Override
	public List<PessoaDTO> buscaPessoas_Contatos() {
			
			List<Pessoa> pessoas = pessoaRepository.buscarPessoas();
		
		
			List<PessoaDTO> listPessoaDTO = new ArrayList<>();

			for(Pessoa pessoa : pessoas) {
				List<Contato> contatos = contatoRepository.buscarContato(pessoa.getId());
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setId( pessoa.getId() );
				pessoaDTO.setNome( pessoa.getNome() );
				pessoaDTO.setEndereco( pessoa.getEndereco() );
				pessoaDTO.setCep(pessoa.getCep());
				pessoaDTO.setCidade( pessoa.getCidade() );
				pessoaDTO.setUf( pessoa.getUf() );
				pessoaDTO.setContatos(contatos);			
				//ID, NOME, ENDERECO, CEP, CIDADE, UF
				
				listPessoaDTO.add(pessoaDTO);			
			}		
			//List<PessoaDTO> listPessoaDTO = pessoaRepository.findPessoasAndQuantidade();
			if(listPessoaDTO.size() > 0)
				return listPessoaDTO;
			return null;
		
	}
		
	
}
