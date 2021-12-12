package br.edu.ifpe.locadora.locadora.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author JJunio
 *
 */

@EnableWebSecurity
@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	// Autenticação/Login
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	}

	// Autorização/Perfil de acesso
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/carros").permitAll()
				.antMatchers(HttpMethod.GET, "/carros/*").permitAll();
	}

	// Recursos estáticos
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
}
