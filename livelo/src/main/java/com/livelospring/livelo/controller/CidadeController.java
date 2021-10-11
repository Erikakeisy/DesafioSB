package com.livelospring.livelo.controller;

import java.util.List;

import com.livelospring.livelo.model.Cidade;
import com.livelospring.livelo.model.dto.CidadeDTO;
import com.livelospring.livelo.repository.CidadeRepository;
import com.livelospring.livelo.service.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RequestMapping("/api")
@RestController
@Api(value = "API REST DE CIDADES")
public class CidadeController {

    @Autowired
    CidadeRepository CRE;

    @Autowired
    CidadeService SC;

    @GetMapping("/cidade/listar")
	@ApiOperation(value = "MÉTODO QUE LISTA TODOS AS CIDADES")
	public List<Cidade>listar(){
	return SC.listar();
	}

    @PostMapping("/cidade/cadastro")
    @ApiOperation(value = "MÉTODO QUE CADASTRA CIDADE")
    public Cidade cidade(@RequestBody CidadeDTO cidadeDTO) {
		return SC.cadastrar(cidadeDTO);
	 }
	
	@GetMapping("/cidade/busca/{nome}}")
	@ApiOperation(value = "MÉTODO BUSCA CIDADE POR NOME")
	public List<Cidade> busca(@RequestParam String nome){
	  	return SC.buscanome(nome);
	   }

    @GetMapping("/cidade/busca/{estado}")
	@ApiOperation(value = "MÉTODO BUSCA CIDADE POR ESTADO")
	public List<Cidade> buscaestado(@RequestParam String estado){
	  	return SC.buscaestado(estado);
	   }

    @GetMapping("/cidade/listar/{id}")
	@ApiOperation(value = "MÉTODO QUE BUSCA CIDADE POR ID")
	public Cidade listId(@PathVariable(value = "id")long id) {
		return CRE.findById(id);
	}

    @DeleteMapping("/cidade/deletar/{id}")
	@ApiOperation(value = "MÉTODO QUE DELETA CIDADE PELO ID")
	public void delete(@PathVariable Long id){
		SC.delete(id);
	}
    
	}



    
