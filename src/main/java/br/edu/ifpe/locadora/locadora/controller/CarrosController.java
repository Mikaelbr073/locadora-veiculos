package br.edu.ifpe.locadora.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.locadora.locadora.dto.CarroDTO;
import br.edu.ifpe.locadora.locadora.entity.Carro;
import br.edu.ifpe.locadora.locadora.repository.CarroRepository;

/**
 * @author JJunio
 *
 */
@RestController
public class CarrosController {

	@Autowired
	private CarroRepository carroRepository;

	@RequestMapping("/carros")
	public List<CarroDTO> listAll() {
		List<Carro> listaTodos = carroRepository.findAll();
		return CarroDTO.converterListaCarroDTO(listaTodos);
	}

}
