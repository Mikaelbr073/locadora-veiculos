package br.edu.ifpe.locadora.dto;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.locadora.entity.Aluguel;
import br.edu.ifpe.locadora.entity.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {
	private long id;
	private String nome;
	private String cnh;
	private List<Aluguel> alugueis = new ArrayList<>();
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cnh = cliente.getCnh();		
	}
	
	
	public static List<ClienteDTO> converterListaClienteDTO(List<Cliente> clientes) {
		List<ClienteDTO> listaConvertida = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			listaConvertida.add(new ClienteDTO(cliente));
		}
		return listaConvertida;
	}


}
