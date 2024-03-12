package br.com.diogo.App.Contatos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.diogo.App.Contatos.model.Contato;

@Repository
public interface ContatoRepository  extends JpaRepository<Contato, Long> {

	@Query(value = "SELECT id,tipocontato,contato,id_pessoa FROM PUBLIC.CONTATOS  WHERE id_pessoa=:id_pessoa ",nativeQuery = true)
	List<Contato> findById_pessoa(@Param("id_pessoa") Long id);
	

}
