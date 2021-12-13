package br.edu.ifpe.locadora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String placa;
	private String modelo;
	private String marca;
	private String cor;
	private String ano;
	private boolean disponivel = true;

	public Carro(String placa, String modelo, String marca, String cor, String ano) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.ano = ano;
	}

	public Carro() {

	}
}
