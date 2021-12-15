package br.edu.ifpe.locadora.form;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.repository.CarroRepository;

/**
 * @author JJunio
 *
 */
public class AtualizacaoCarroForm {

	@NotNull @NotEmpty
	private String ano;
	@NotNull @NotEmpty
	private String cor;
	@Valid
	private boolean disponivel;

	public Carro atualizar(Long id, CarroRepository repository) {
		Carro carro = repository.getById(id);

		carro.setAno(this.ano);
		carro.setCor(this.cor);
		carro.setDisponivel(this.disponivel);

		return carro;
	}

	public Carro converter(long id, CarroRepository carroRepository) {
		Carro carroBD = carroRepository.getById(id);
		carroBD.setAno(ano);
		carroBD.setCor(cor);
		carroBD.setDisponivel(disponivel);
		return carroBD;
	}

}
