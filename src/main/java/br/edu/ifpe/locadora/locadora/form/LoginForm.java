package br.edu.ifpe.locadora.locadora.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author JJunio
 *
 */

public class LoginForm {

	private String email;
	private String senha;

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.email, this.senha);
	}

}
