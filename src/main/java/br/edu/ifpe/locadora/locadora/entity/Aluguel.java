package br.edu.ifpe.locadora.locadora.entity;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String carro;
	private Date retirada;
	private Date devolucao;
	private double valor;
	@OneToOne
	private Cliente cliente;
	
}
