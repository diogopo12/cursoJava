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

import br.com.diogo.App.Contatos.model.ContatoSimples;
import br.com.diogo.App.Contatos.service.ContatoSimplesService;

@RestController
@RequestMapping("/api/contatos") //http://localhost:8080/api/contatos
public class ContatoSimplesResource {



	private ContatoSimplesService contato_Service;

	
	@Autowired
	public ContatoSimplesResource(ContatoSimplesService contat) {
			this.contato_Service = contat;
	}
	
	

	@GetMapping
	public ResponseEntity<List<ContatoSimples>> getAllContatoSimpless(){
		List<ContatoSimples> ContatoSimpless = contato_Service.getAll();
		if(ContatoSimpless == null)
			return ResponseEntity.notFound().build();
		if(ContatoSimpless.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ContatoSimpless);
	}

	
	
	@PostMapping
	public ResponseEntity<ContatoSimples> save(@RequestBody ContatoSimples contato){
		ContatoSimples newContatoSimples = contato_Service.save(contato);
		if(newContatoSimples == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContatoSimples);
	}
	
	@GetMapping("/{id}") //http://localhost:8080/api/agenda/2
	public ResponseEntity<Optional<ContatoSimples>> getById(@PathVariable Long id){
		Optional<ContatoSimples> ContatoSimples = contato_Service.getById(id);
		if(ContatoSimples == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ContatoSimples);
	}
	
	@PutMapping
	public ResponseEntity<ContatoSimples> update(@RequestBody ContatoSimples ContatoSimples){
		ContatoSimples upContatoSimples = contato_Service.update(ContatoSimples);
		if(upContatoSimples == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upContatoSimples);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contato_Service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //status code 204
	}
	

	
	
	
}
	
	

