package br.edu.ifpe.locadora.locadora.form;

import com.sun.istack.NotNull;

import br.edu.ifpe.locadora.locadora.entity.Carro;
import br.edu.ifpe.locadora.locadora.repository.CarroRepository;

/**
 * @author JJunio
 *
 */
public class AtualizacaoCarroForm {

	private String ano;
	private String cor;
	private boolean disponivel;

	public Carro atualizar(Long id, CarroRepository repository) {
		Carro carro = repository.getById(id);

		carro.setAno(this.ano);
		carro.setCor(this.cor);
		carro.isDisponvel(this.disponivel);

		return carro;
	}

}
