package br.edu.ifpe.locadora.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifpe.locadora.dto.AluguelDTO;
import br.edu.ifpe.locadora.entity.Aluguel;
import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.form.ClienteFormAluguel;
import br.edu.ifpe.locadora.repository.AluguelRepository;
import br.edu.ifpe.locadora.repository.CarroRepository;
import br.edu.ifpe.locadora.repository.ClienteRepository;
import br.edu.ifpe.locadora.service.AluguelService;

/**
 * @author JJunio
 *
 */
@RestController
public class AluguelController {

	@Autowired
	private AluguelRepository aluguelRepository;
	@Autowired
	private CarroRepository carroRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/locadora/aluguel")
	@Transactional
	public ResponseEntity<Aluguel> alugarCarro(@RequestBody @Valid ClienteFormAluguel form,
			UriComponentsBuilder uriBuilder) {

		Aluguel novoAluguel = AluguelService.alugar(form, carroRepository, clienteRepository);

		if (novoAluguel != null) {
			aluguelRepository.save(novoAluguel);
			URI uri = uriBuilder.path("/locadora/aluguel/{id}").buildAndExpand(novoAluguel.getId()).toUri();
			return ResponseEntity.created(uri).body(novoAluguel);

		}
		return ResponseEntity.notFound().build();

	}

	@GetMapping("/locadora/aluguel")
	public List<AluguelDTO> listarTodosAlugueis() {
		List<Aluguel> listaTodos = aluguelRepository.findAll();
		return AluguelDTO.converterListaAlugueleDTO(listaTodos);
	}

	@GetMapping("/locadora/aluguel/{id}")
	public ResponseEntity<AluguelDTO> detalhar(@PathVariable long id) {
		Optional<Aluguel> optionalAluguel = aluguelRepository.findById(id);
		if (optionalAluguel.isPresent()) {

			return ResponseEntity.ok(new AluguelDTO(optionalAluguel.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/locadora/aluguel/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable long id) {
		Optional<Aluguel> optionalAluguel = aluguelRepository.findById(id);
		if (optionalAluguel.isPresent()) {
			Carro carro = optionalAluguel.get().getCarro();
			carro.setDisponivel(true);
			aluguelRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
