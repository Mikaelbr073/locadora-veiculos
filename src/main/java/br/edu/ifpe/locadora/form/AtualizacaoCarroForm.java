package br.edu.ifpe.locadora.form;

import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.repository.CarroRepository;

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
		carro.setDisponivel(this.disponivel);

		return carro;
	}

}
