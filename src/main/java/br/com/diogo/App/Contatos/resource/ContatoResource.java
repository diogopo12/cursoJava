package br.com.diogo.App.Contatos.resource;

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

import br.com.diogo.App.Contatos.dto.ContatoDTO;
import br.com.diogo.App.Contatos.model.Contato;
import br.com.diogo.App.Contatos.model.Pessoa;
import br.com.diogo.App.Contatos.service.ContatoService;

@RestController
@RequestMapping("/api/contatosRelacionados") //http://localhost:8080/api/contatos
public class ContatoResource {



	private ContatoService contatoService;

	
	@Autowired
	public ContatoResource(ContatoService contat) {
			this.contatoService = contat;
	}
	
	

	@GetMapping
	public ResponseEntity<List<Contato>> getAllContatos(){
		List<Contato> Contatos = contatoService.getAll();
		if(Contatos == null)
			return ResponseEntity.notFound().build();
		if(Contatos.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(Contatos);
	}

	
	
	
	
	@GetMapping("/{id}") //http://localhost:8080/api/agenda/2
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
		Optional<Contato> Contato = contatoService.getById(id);
		if(Contato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(Contato);
	}
	

	
	
	
}
	
	

