package br.edu.ifpe.locadora.locadora.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpe.locadora.locadora.entity.Usuario;

/**
 * @author JJunio
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	Usuario findByEmail(String email);
}
