package com.livelospring.livelo.controller;

import java.util.List;


import com.livelospring.livelo.model.Cliente;

import com.livelospring.livelo.repository.ClienteRepository;
import com.livelospring.livelo.service.ClienteService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ClienteController {


	@Autowired
	ClienteRepository CR;

	@Autowired
	ClienteService CS;

	@GetMapping("/cliente/listar")
	@ApiOperation(value = "MÉTODO QUE LISTA TODOS OS CLIENTES")
	public List<Cliente>listar(){
	return CS.listar();
	}

    @PostMapping("/cliente/cadastro")
    @ApiOperation(value = "MÉTODO QUE CADASTRA CLIENTE")
    public Cliente cliente(@RequestBody Cliente cliente) {
		return CS.cadastrar(cliente);
	 }
	
	@GetMapping("/cliente/busca/{nome}")
	@ApiOperation(value = "MÉTODO BUSCA CLIENTE POR NOME")
	public List<Cliente> busca(@PathVariable (value = "nome") String nome){
	  	return CS.busca(nome);
	   }

	@DeleteMapping("/cliente/deletar/{id}")
	@ApiOperation(value = "MÉTODO QUE DELETA CLIENTE PELO ID")
	public void delete(@PathVariable Long id){
		CS.Delete(id);
	}

	@DeleteMapping("/cliente/delete")
	@ApiOperation(value = "MÉTODO QUE DELETA CLIENTE INTEIRO")
	public void deletaCliente(@RequestBody Cliente cliente) {
    CR.delete(cliente);
    }

	@GetMapping("/cliente/listar/{id}")
	@ApiOperation(value = "MÉTODO QUE MOSTRA CLIENTE PELO ID")
	public Cliente listarId(@PathVariable(value = "id")long id) {
    return CR.findById(id);
   }

    @PutMapping("/cliente/alterar/infos")
	@ApiOperation(value = "MÉTODO QUE ALTERA INFOS DO CLIENTE")
	public Cliente alterarCliente(@RequestBody Cliente cliente) {
		return CR.save(cliente);
	}

	
	}


