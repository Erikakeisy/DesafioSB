package com.livelospring.livelo.service;

import java.util.List;
import java.util.Optional;

import com.livelospring.livelo.model.Cidade;
import com.livelospring.livelo.model.dto.CidadeDTO;
import com.livelospring.livelo.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CidadeService {


    @Autowired
    CidadeRepository CR;

    
    public List<Cidade> listar(){
        return CR.findAll();
    }

    public List<Cidade> buscanome(String nome){
        return (List<Cidade>) CR.findBynome(nome);
    }

    public List<Cidade> buscaestado(String estado){
        return (List<Cidade>) CR.findByestado(estado);
    }

    public Cidade cadastrar(CidadeDTO cidadeDTO) {
		return CR.save(cidadeDTO.entity(cidadeDTO));
	}
    
    public void delete(@PathVariable Long id){
		Optional<Cidade> cidade = CR.findById(id);
		if(cidade.isPresent()){
			CR.deleteById(id);	
		}
	
	}




    
}
