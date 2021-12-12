package br.edu.ifpe.locadora.locadora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author JJunio
 *
 */

@EnableWebSecurity
@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

	@Autowired
	AutenticacaoService autenticacaoService;

	// Autenticação/Login
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// Autorização/Perfil de acesso
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/carros").permitAll()
				.antMatchers(HttpMethod.GET, "/carros/*").permitAll().antMatchers(HttpMethod.POST, "/auth").permitAll();
		// .anyRequest().authenticated().and().csrf().disable().sessionManagement()
		// .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	// Recursos estáticos
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
}
