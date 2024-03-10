package br.com.diogo.App.Contatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.diogo.App.Contatos.model.ContatoSimples;


@Repository
public interface ContatoSimplesRepository  extends JpaRepository<ContatoSimples, Long> {
	
	@Query(value = "SELECT id,tipocontato,contato,id_pessoa FROM PUBLIC.CONTATOS where id_pessoa=:idPessoa", nativeQuery = true)
	List<ContatoSimples> buscarContato(@Param("idPessoa") Long id); //busca por contatos
	
}
