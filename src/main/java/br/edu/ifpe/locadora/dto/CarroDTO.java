package br.edu.ifpe.locadora.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.locadora.entity.Carro;
import lombok.Data;

/**
 * @author JJunio
 *
 */
@Data
public class CarroDTO {

	private long id;
	private String modelo;
	private String marca;
	private String cor;
	private String ano;
	private boolean disponivel;

	public CarroDTO(Carro carro) {
		this.id = carro.getId();
		this.ano = carro.getAno();
		this.marca = carro.getMarca();
		this.cor = carro.getCor();
		this.modelo = carro.getModelo();
		this.disponivel = carro.isDisponivel();
	}

	public static List<CarroDTO> converterListaCarroDTO(List<Carro> carros) {
		List<CarroDTO> listaConvertida = new ArrayList<CarroDTO>();
		for (Carro carro : carros) {
			listaConvertida.add(new CarroDTO(carro));
		}
		return listaConvertida;
	}

}
