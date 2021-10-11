package com.livelospring.livelo.service;

import java.util.List;
import java.util.Optional;

import com.livelospring.livelo.model.Cliente;
import com.livelospring.livelo.model.dto.ClienteDTO;
import com.livelospring.livelo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;



@Service
public class ClienteService {

@Autowired
ClienteRepository CR;

    public List<Cliente> busca(String nome){
        return (List<Cliente>) CR.findBynome(nome);
    }

    public List<Cliente> listar(){
        return CR.findAll();
    }

	public Cliente cadastrar(ClienteDTO clienteDTO) {
		return CR.save(clienteDTO.entity(clienteDTO));
	}

    public void Delete(@PathVariable Long id){
		Optional<Cliente> cliente = CR.findById(id);
		if(cliente.isPresent()){
			CR.deleteById(id);	
		}
	
	}
}
