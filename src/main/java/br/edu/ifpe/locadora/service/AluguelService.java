package br.edu.ifpe.locadora.service;

import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpe.locadora.controller.ClienteFormAluguel;
import br.edu.ifpe.locadora.entity.Aluguel;
import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.entity.Cliente;
import br.edu.ifpe.locadora.repository.CarroRepository;
import br.edu.ifpe.locadora.repository.ClienteRepository;
import lombok.Data;

/**
 * @author JJunio
 *
 */
@Data
public class AluguelService {

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Aluguel alugar(@Valid ClienteFormAluguel form) {

		Aluguel alugado = new Aluguel();

		Carro carro = carroRepository.findByPlaca(form.getPlaca());

		Cliente cliente = clienteRepository.findByNome(form.getNome());

		Date dataRetirada = new Date();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date dataDevolucao = cal.getTime();

		carro.setDisponivel(false);

		alugado.setCarro(carro);
		alugado.setRetirada(dataRetirada);
		alugado.setDevolucao(dataDevolucao);
		alugado.calculaValor();
		cliente.setAlugado(alugado);

		return alugado;
	}

}
