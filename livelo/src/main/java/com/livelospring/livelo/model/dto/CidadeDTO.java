package com.livelospring.livelo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.livelospring.livelo.model.Cidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {

    private String nome;
    private String estado;

    public CidadeDTO Dto(Cidade cidade) {
        CidadeDTO cidadeDto = new CidadeDTO();
        cidadeDto.setNome(cidade.getNome());
        cidadeDto.setEstado(cidade.getEstado());
        return cidadeDto;
        }

    public Cidade entity(CidadeDTO cidadeDTO){
        Cidade cidade = new Cidade();
        cidade.setNome(cidadeDTO.getNome());
        cidade.setEstado(cidadeDTO.getEstado());
        return cidade;
    }

    public List<CidadeDTO> Dto(List<Cidade> list){
        return list.stream().map(cidade -> Dto(cidade)).collect(Collectors.toList());
    }

    
}
