package br.edu.utfpr.autorepairshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Parâmetro(s) inválido(s).")
public class InvalidParamsException extends IllegalArgumentException {

	public InvalidParamsException(String message){
		super(message);
	}
}