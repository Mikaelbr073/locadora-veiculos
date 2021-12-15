package br.edu.ifpe.locadora.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author JJunio
 *
 */
@Data
public class ClienteFormAluguel {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String placa;

}
