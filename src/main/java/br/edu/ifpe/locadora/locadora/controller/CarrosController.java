package br.edu.ifpe.locadora.locadora.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifpe.locadora.locadora.dto.CarroDTO;
import br.edu.ifpe.locadora.locadora.dto.CarroFormDTO;
import br.edu.ifpe.locadora.locadora.entity.Carro;
import br.edu.ifpe.locadora.locadora.repository.CarroRepository;

/**
 * @author JJunio
 *
 */
@RestController
@RequestMapping("/carros")
public class CarrosController {

	@Autowired
	private CarroRepository carroRepository;
	
	

	@GetMapping
	@Cacheable(value = "listaDCarros")
	public List<CarroDTO> listAll() {
		List<Carro> listaTodos = carroRepository.findAll();
		return CarroDTO.converterListaCarroDTO(listaTodos);
	}
	

	@PostMapping
	@CacheEvict(value="listaDCarros", allEntries = true)
	public ResponseEntity<CarroDTO> cadastrar(@RequestBody @Validated CarroFormDTO form,
			UriComponentsBuilder uriBuilder) {

		Carro novoCarro = form.converter();
		carroRepository.save(novoCarro);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(novoCarro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarroDTO(novoCarro));

	}

	@GetMapping("/{id}")
	@Cacheable(value = "carroId")
	public CarroDTO detalhar(@PathVariable long id) {
		Carro carro = carroRepository.getById(id);
		return new CarroDTO(carro);

	}

}
