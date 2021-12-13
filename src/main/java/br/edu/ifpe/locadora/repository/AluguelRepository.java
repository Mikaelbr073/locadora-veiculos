package br.edu.ifpe.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpe.locadora.entity.Aluguel;

/**
 * @author JJunio
 *
 */
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{

}
