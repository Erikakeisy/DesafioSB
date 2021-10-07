package com.livelospring.livelo.repository;

import java.util.List;


import com.livelospring.livelo.model.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findById(long id);

    List<Cliente>findBynome(String nome);
    
}
