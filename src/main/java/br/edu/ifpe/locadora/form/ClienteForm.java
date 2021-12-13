package br.edu.ifpe.locadora.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.ifpe.locadora.entity.Cliente;
import lombok.Data;

@Data
public class ClienteForm {
	
	@NotNull @NotEmpty
	private String nome;
	private String cnh;
	
	
	public Cliente converter() {
		return new Cliente(this.nome, this.cnh);
	}

}
