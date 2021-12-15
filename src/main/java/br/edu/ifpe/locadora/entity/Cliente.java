package br.edu.ifpe.locadora.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	@Column(unique = true)
	private String cnh;
	
	public Cliente( ) {}
	
	public Cliente(String nome, String cnh) {
		super();
		this.nome = nome;
		this.cnh = cnh;
	}
	
	
	
	
	
	
}
