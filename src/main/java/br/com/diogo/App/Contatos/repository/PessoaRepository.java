package br.com.diogo.App.Contatos.repository;

import org.springframework.stereotype.Repository;

import br.com.diogo.App.Contatos.model.Pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {



}
