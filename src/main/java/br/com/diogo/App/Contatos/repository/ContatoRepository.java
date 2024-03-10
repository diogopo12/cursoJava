package br.com.diogo.App.Contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.diogo.App.Contatos.model.Contato;

@Repository
public interface ContatoRepository  extends JpaRepository<Contato, Long> {
	
	@Query(value = "SELECT id,tipocontato,contato,id_pessoa FROM PUBLIC.CONTATOS where id_pessoa=:idPessoa", nativeQuery = true)
	List<Contato> buscarContato(@Param("idPessoa") Long id); //busca por contatos
	
}
