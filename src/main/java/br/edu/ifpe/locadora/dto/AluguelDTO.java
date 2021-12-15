package br.edu.ifpe.locadora.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpe.locadora.entity.Aluguel;
import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.entity.Cliente;
import lombok.Data;

/**
 * @author JJunio
 *
 */
@Data
public class AluguelDTO {

	private String nomeCliente;
	private String modeloCarro;
	private String marcaCarro;
	private String corCarro;
	private double valor;
	private Date dataEmprestimo;
	private Date dataDevolucao;

	public AluguelDTO(Cliente cliente, Aluguel aluguel, Carro carro) {
		super();
		this.nomeCliente = cliente.getNome();
		this.modeloCarro = carro.getModelo();
		this.marcaCarro = carro.getMarca();
		this.corCarro = carro.getCor();
		this.valor = aluguel.getValor();
		this.dataEmprestimo = aluguel.getRetirada();
		this.dataDevolucao = aluguel.getDevolucao();
	}

	public AluguelDTO(Aluguel aluguel) {
		this.nomeCliente = aluguel.getCliente().getNome();
		this.modeloCarro = aluguel.getCarro().getModelo();
		this.valor = aluguel.getValor();
	}

	public static List<AluguelDTO> converterListaAlugueleDTO(List<Aluguel> listaTodos) {
		List<AluguelDTO> listaAluguelDTO = new ArrayList<>();
		for (Aluguel aluguel : listaTodos) {
			listaAluguelDTO.add(new AluguelDTO(aluguel));
		}
		return listaAluguelDTO;
	}

}
