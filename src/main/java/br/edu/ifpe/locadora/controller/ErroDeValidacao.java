package br.edu.ifpe.locadora.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.ifpe.locadora.dto.ErroDTO;

/**
 * @author JJunio
 *
 */
@RestControllerAdvice
public class ErroDeValidacao {

	@Autowired
	private MessageSource mensageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDTO> handler(MethodArgumentNotValidException erro) {
		List<ErroDTO> resultErros = new ArrayList<>();
		List<FieldError> fieldErros = erro.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErros) {
			resultErros.add(new ErroDTO(fieldError.getField(),
					mensageSource.getMessage(fieldError, LocaleContextHolder.getLocale())));
		}
		return resultErros;
	}
}
