package br.edu.ifpe.locadora.controller;

import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifpe.locadora.dto.AluguelDTO;
import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.repository.AluguelRepository;
import br.edu.ifpe.locadora.repository.CarroRepository;

/**
 * @author JJunio
 *
 */
@RestController
public class AluguelController {

	@Autowired
	private CarroRepository carroRepository;

	//@Autowired
	//private ClienteRepository clienteRepository;

	@Autowired
	private AluguelRepository aluguelRepository;

	@PostMapping("/locadora/aluguel")
	@CacheEvict(value = "aluguelCarros")
	public ResponseEntity<AluguelDTO> alugarCarro(@RequestBody @Valid ClienteFormAluguel form,
			UriComponentsBuilder uriBuilder) {

		Carro carro = carroRepository.findByPlaca(form.getPlaca());
	//	Cliente cliente = clienteRepository.findByNome(form.getNome());

		Date dataRetirada = new Date();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Date dataDevolucao = cal.getTime();
/*
		if (carro != null && cliente != null) {
			carro.setDisponivel(false);
			Aluguel aluguel;
			aluguel.setCarro(carro);
			aluguel.setRetirada(dataRetirada);
			aluguel.setDevolucao(dataDevolucao);
			aluguel.calculaValor();

			aluguelRepository.save(aluguel);
			URI uri = uriBuilder.path("/locadora/aluguel/{id}").buildAndExpand(aluguel.getId()).toUri();
			//return ResponseEntity.created(uri).body(new AluguelDTO(cliente, carro, aluguel));
		}
*/
		return ResponseEntity.badRequest().build();

	}

}
