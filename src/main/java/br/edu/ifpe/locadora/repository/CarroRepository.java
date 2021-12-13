package br.edu.ifpe.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpe.locadora.entity.Carro;

/**
 * @author JJunio
 *
 */
public interface CarroRepository extends JpaRepository<Carro, Long>{

	List<Carro> findByMarca(String marca);

	Carro findByPlaca(String placa);

}
