package br.edu.ifpe.locadora.locadora.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.locadora.locadora.entity.Carro;

/**
 * @author JJunio
 *
 */
public class CarroDTO {

	private long id;
	private String marca;
	private String cor;
	private String ano;
	private boolean disponivel;

	public CarroDTO(Carro carro) {
//		this.id = carro.getId();
//		this.ano = carro.getAno();
//		this.marca = carro.getMarca();
//		this.cor = carro.getCor();
		// this.disponivel = carro.getDisponivel();
	}

	public long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public String getAno() {
		return ano;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public static List<CarroDTO> converterListaCarroDTO(List<Carro> carros) {
		List<CarroDTO> listaConvertida = new ArrayList<CarroDTO>();
		for (Carro carro : carros) {
			listaConvertida.add(new CarroDTO(carro));
		}
		return listaConvertida;
	}

}
