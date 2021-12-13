package br.edu.ifpe.locadora.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifpe.locadora.dto.CarroDTO;
import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.form.CarroForm;
import br.edu.ifpe.locadora.repository.CarroRepository;

/**
 * @author JJunio
 *
 */
@RestController
@RequestMapping("/locadora/carros")
public class CarrosController {

	@Autowired
	private CarroRepository carroRepository;

	@GetMapping
	@Cacheable(value = "listaDCarros")
	public List<CarroDTO> listarTodos() {
		List<Carro> listaTodos = carroRepository.findAll();
		return CarroDTO.converterListaCarroDTO(listaTodos);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDCarros")
	public ResponseEntity<CarroDTO> cadastrar(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder) {

		System.out.println(form.toString());
		Carro novoCarro = form.converter();
		carroRepository.save(novoCarro);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(novoCarro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarroDTO(novoCarro));

	}

	@GetMapping("/{id}")
	public ResponseEntity<CarroDTO> detalhar(@PathVariable long id) {
		Optional<Carro> optionalCarro = carroRepository.findById(id);
		if (optionalCarro.isPresent()) {
			return ResponseEntity.ok(new CarroDTO(optionalCarro.get()));
		}

		return ResponseEntity.badRequest().build();

	}

	@DeleteMapping
	@Transactional
	@CacheEvict(value = "listaDCarros", allEntries = true)
	public ResponseEntity<?> deletar(@PathVariable long id) {
		Optional<Carro> optionalCarro = carroRepository.findById(id);
		if (optionalCarro.isPresent()) {
			carroRepository.deleteById(id);
			ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();
	}

}
