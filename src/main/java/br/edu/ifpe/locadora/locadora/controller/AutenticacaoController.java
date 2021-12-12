package br.edu.ifpe.locadora.locadora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.locadora.locadora.form.LoginForm;

/**
 * @author JJunio
 *
 */
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Validated LoginForm loginForm) {
		//UsernamePasswordAuthenticationToken login = loginForm.converter();

		System.out.println(loginForm.getSenha() + "/n" + loginForm.getEmail());
		return ResponseEntity.ok().build();
	}

}
