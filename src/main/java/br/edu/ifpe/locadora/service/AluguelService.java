package br.edu.ifpe.locadora.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import br.edu.ifpe.locadora.entity.Aluguel;
import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.entity.Cliente;
import br.edu.ifpe.locadora.form.ClienteFormAluguel;
import br.edu.ifpe.locadora.repository.CarroRepository;
import br.edu.ifpe.locadora.repository.ClienteRepository;

/**
 * @author JJunio
 *
 */

public class AluguelService {

	public static Aluguel alugar(ClienteFormAluguel form, CarroRepository carroRepository,
			ClienteRepository clienteRepository) {

		Aluguel alugado = new Aluguel();

		Optional<Carro> carro = carroRepository.findByPlaca(form.getPlaca());

		Optional<Cliente> cliente = clienteRepository.findByNome(form.getNome());

		Date dataRetirada = new Date();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date dataDevolucao = cal.getTime();

		if (carro.isPresent() && cliente.isPresent() && carro.get().isDisponivel()) {
			carro.get().setDisponivel(false);
			alugado.setCarro(carro.get());
			alugado.setRetirada(dataRetirada);
			alugado.setDevolucao(dataDevolucao);
			alugado.calculaValor();
			alugado.setCliente(cliente.get());
			;

			return alugado;
		}
		return null;

	}
}
