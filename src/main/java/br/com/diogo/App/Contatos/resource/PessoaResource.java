package br.com.diogo.App.Contatos.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diogo.App.Contatos.dto.PessoaDTO;
import br.com.diogo.App.Contatos.model.Pessoa;
import br.com.diogo.App.Contatos.service.PessoaService;



@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {



	private PessoaService pessoaService;

	
	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;		
	}
	
	

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> getAllPessoas(){
		List<PessoaDTO> PessoasDTO = pessoaService.getAll();
		if(PessoasDTO == null)
			return ResponseEntity.notFound().build();
		if(PessoasDTO.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(PessoasDTO);
	}

	
	
	@PostMapping
	public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO PessoaDTO){
		PessoaDTO newPessoa = pessoaService.save(PessoaDTO);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
	}
	
	@GetMapping("/{id}") //http://localhost:8080/api/agenda/2
	public ResponseEntity<Optional<PessoaDTO>> getById(@PathVariable Long id){
		Optional<PessoaDTO> Pessoa = pessoaService.getById(id);
		if(Pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(Pessoa);
	}
	
	@PutMapping
	public ResponseEntity<PessoaDTO> update(@RequestBody PessoaDTO PessoaDTO){
		PessoaDTO upPessoa = pessoaService.update(PessoaDTO);
		if(upPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upPessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //status code 204
	}	
	
	
	
}
