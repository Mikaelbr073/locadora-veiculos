package br.edu.ifpe.locadora.locadora.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
	@Id
	private int id;

	public Carro() {

	}

	public int getId() {
		return id;
	}
	
}
