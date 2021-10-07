package com.livelospring.livelo.repository;

import java.util.List;

import com.livelospring.livelo.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
    Cidade findById(long id);

    List<Cidade>findBynome(String nome);

    List<Cidade>findByestado(String estado);
    
}
