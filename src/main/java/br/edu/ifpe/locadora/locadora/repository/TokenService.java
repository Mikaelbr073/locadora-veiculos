package br.edu.ifpe.locadora.locadora.repository;

import java.util.Date;

import org.springframework.security.core.Authentication;

import br.edu.ifpe.locadora.locadora.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author JJunio
 *
 */

public class TokenService {

	private final String CHAVE = "bc7effbcfa1e38064ad314acc88fefd63d4873588ce23a4d66502668038e25c8";

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date data = new Date();
		Date expiracao = new Date(data.getTime() + 600000);

		return Jwts.builder().setIssuer("Locadora IFPE").setSubject(new String("" + logado.getId())).setIssuedAt(data)
				.setExpiration(expiracao).signWith(SignatureAlgorithm.ES256, CHAVE).compact();
	}

}
