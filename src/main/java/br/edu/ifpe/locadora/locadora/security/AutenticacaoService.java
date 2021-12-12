package br.edu.ifpe.locadora.locadora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpe.locadora.locadora.entity.Usuario;
import br.edu.ifpe.locadora.locadora.repository.UsuarioRepository;

/**
 * @author JJunio
 *
 */
@Service
public class AutenticacaoService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(username);
		
		if(usuario != null) {
			return usuario;
		}
		
		throw  new UsernameNotFoundException("Dados inválidos");
	}

}
