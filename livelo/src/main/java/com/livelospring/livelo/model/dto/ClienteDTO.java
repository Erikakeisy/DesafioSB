package com.livelospring.livelo.model.dto;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.livelospring.livelo.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    
	private String nome;
    private LocalDate dt_nascimento;
    private int idade;
    private  char sexo;
    private String cidade;

    public Cliente entity(ClienteDTO Dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(Dto.getNome());
        cliente.setDt_nascimento(Dto.getDt_nascimento());
        cliente.setIdade(Dto.getIdade());
        cliente.setSexo(Dto.getSexo());
        cliente.setCidade(Dto.getCidade());
        return cliente;
        }
        
        public ClienteDTO Dto(Cliente cliente) {
        ClienteDTO clientedto = new ClienteDTO();
        clientedto.setNome(cliente.getNome());
        clientedto.setDt_nascimento(cliente.getDt_nascimento());
        clientedto.setIdade(cliente.getIdade());
        clientedto.setSexo(cliente.getSexo());
        clientedto.setCidade(cliente.getCidade());
        return clientedto;
        }
        
        public List<ClienteDTO> Dto (List<Cliente> list){
            return list.stream().map(cliente -> Dto(cliente)).collect(Collectors.toList());
        }
        }


