package br.edu.ifpe.locadora.dto;

import lombok.Data;

/**
 * @author JJunio
 *
 */
@Data
public class ErroDTO {

	private String campo;
	private String mesnagem;

	public ErroDTO(String campo, String mesnagem) {
		super();
		this.campo = campo;
		this.mesnagem = mesnagem;
	}

}
