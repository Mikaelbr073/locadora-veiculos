package br.edu.ifpe.locadora.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.ifpe.locadora.entity.Carro;
import lombok.Data;

@Data
public class CarroForm {

	@NotNull
	@NotEmpty
	@Size(min = 7)
	private String placa;
	@Size(min = 3)
	@NotNull
	@NotEmpty
	private String modelo;
	@Size(min = 3)
	@NotNull
	@NotEmpty
	private String marca;
	@Size(min = 3)
	@NotNull
	@NotEmpty
	private String cor;
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 4)
	private String ano;

	public Carro converter() {
		return new Carro(this.placa, this.modelo, this.marca, this.cor, this.ano);
	}

}
