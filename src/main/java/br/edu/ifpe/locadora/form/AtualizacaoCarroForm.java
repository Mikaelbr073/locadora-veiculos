package br.edu.ifpe.locadora.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.ifpe.locadora.entity.Carro;
import br.edu.ifpe.locadora.repository.CarroRepository;
import lombok.Data;

/**
 * @author JJunio
 *
 */
@Data
public class AtualizacaoCarroForm {

	private String ano;
	private String cor;
	@NotNull
	@NotEmpty
	private String disponivel;

	public AtualizacaoCarroForm() {

	}

	public Carro converter(long id, CarroRepository carroRepository) {
		Carro carroBD = carroRepository.getById(id);
		carroBD.setAno(this.ano);
		carroBD.setCor(this.cor);
		carroBD.setDisponivel(Boolean.valueOf(this.disponivel));
		
		return carroBD;
	}

}
