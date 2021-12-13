package br.edu.ifpe.locadora.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.ifpe.locadora.entity.Carro;
import lombok.Data;

@Data
public class CarroForm {

	@NotNull @NotEmpty
	private String placa;
	private String modelo;
	private String marca;
	private String cor;
	private String ano;

	public Carro converter() {
		return new Carro(this.placa, this.modelo, this.marca, this.cor, this.ano);
	}

}
