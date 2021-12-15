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
import br.edu.ifpe.locadora.dto.ClienteDTO;
import br.edu.ifpe.locadora.entity.Cliente;

import br.edu.ifpe.locadora.form.ClienteForm;
import br.edu.ifpe.locadora.repository.ClienteRepository;

@RestController
@RequestMapping("/locadora/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	@Cacheable(value = "listaDClientes")
	public List<ClienteDTO> listarTodos() {
		List<Cliente> listaTodos = clienteRepository.findAll();
		return ClienteDTO.converterListaClienteDTO(listaTodos);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDCliente")
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {

		System.out.println(form.toString());
		Cliente novoCliente = form.converter();
		clienteRepository.save(novoCliente);

		URI uri = uriBuilder.path("/locadora/cliente/{id}").buildAndExpand(novoCliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(novoCliente));

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> detalhar(@PathVariable long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			System.out.println(optionalCliente.get());
			return ResponseEntity.ok(new ClienteDTO(optionalCliente.get()));
		}
		System.out.println(optionalCliente.get());
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value = "listaDClientes")
	public ResponseEntity<?> deletar(@PathVariable long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	

}
