package br.edu.ifpe.locadora.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifpe.locadora.entity.Aluguel;
import br.edu.ifpe.locadora.repository.AluguelRepository;
import br.edu.ifpe.locadora.service.AluguelService;

/**
 * @author JJunio
 *
 */
@RestController
public class AluguelController {

	@Autowired
	private AluguelRepository aluguelRepository;

	@PostMapping("/locadora/aluguel")
	@CacheEvict(value = "aluguelCarros")
	public ResponseEntity<Aluguel> alugarCarro(@RequestBody @Valid ClienteFormAluguel form,
			UriComponentsBuilder uriBuilder) {

		AluguelService servicoAluguel = new AluguelService();
		Aluguel novoAluguel = servicoAluguel.alugar(form);

		aluguelRepository.save(novoAluguel);
		URI uri = uriBuilder.path("/locadora/aluguel/{id}").buildAndExpand(novoAluguel.getId()).toUri();
		return ResponseEntity.created(uri).body(novoAluguel);

	}

}
