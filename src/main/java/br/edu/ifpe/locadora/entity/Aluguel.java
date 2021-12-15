package br.edu.ifpe.locadora.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Carro carro;
	private Date retirada;
	private Date devolucao;
	private double valor;
	@OneToOne
	private Cliente cliente;

	public void calculaValor() {
		if (this.getCarro().getCor().toLowerCase() == "PRETA" || this.getCarro().getCor().toLowerCase() == "PRETA") {
			this.valor = 200;
		} else {
			this.valor = 150;
		}

	}
}
