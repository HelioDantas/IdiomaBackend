package br.com.matrix.idioma.config;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
	{
		ExceptionDetails erro = new ExceptionDetails();
		erro.setDetail(exception.getMessage());
		erro.setDevMensagem(exception.getClass().getName());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setTimeStamp(LocalDate.now());
		erro.setTitle(PAGE_NOT_FOUND_LOG_CATEGORY);
		
		return handleExceptionInternal(exception, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
}
