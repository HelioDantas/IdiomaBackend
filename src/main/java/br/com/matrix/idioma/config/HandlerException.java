package br.com.matrix.idioma.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	private static final String PAGE_ILLEGAL_ARGUMENT = "ILLEGAL ARGUMENT";

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
	{
		ExceptionDetails erro = new ExceptionDetails();
		erro.setDetail(exception.getMessage());
		erro.setDevMensagem(exception.getClass().getName());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setTimeStamp(getLocalDateTimeNow());
		erro.setTitle(PAGE_NOT_FOUND_LOG_CATEGORY);
		
		return handleExceptionInternal(exception, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(value = {ResourceIllegalArgumentException.class})
	public ResponseEntity<Object> handlerResourceIllegalArgumentException(ResourceIllegalArgumentException exception, WebRequest request)
	{
		ExceptionDetails erro = new ExceptionDetails();
		erro.setDetail(exception.getMessage());
		erro.setDevMensagem(exception.getClass().getName());
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setTimeStamp(getLocalDateTimeNow());
		erro.setTitle(PAGE_ILLEGAL_ARGUMENT);
		
		return handleExceptionInternal(exception, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private static final String PAGE_OBJECT_REGISTERED = "OBJECT ALREADY REGISTERED";

	@ExceptionHandler(value = {ResourceObjectRegisteredException.class})
	public ResponseEntity<Object> handlerResourceObjectRegisteredException(ResourceObjectRegisteredException exception, WebRequest request)
	{
		ExceptionDetails erro = new ExceptionDetails();
		erro.setDetail(exception.getMessage());
		erro.setDevMensagem(exception.getClass().getName());
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setTimeStamp(getLocalDateTimeNow());
		erro.setTitle(PAGE_OBJECT_REGISTERED);
		
		return handleExceptionInternal(exception, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	

	private String getLocalDateTimeNow() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter
		  .ofLocalizedDateTime(FormatStyle.SHORT)
		  .withLocale(new Locale("pt", "br"));
		return agora.format(formatador); 
	}
	
	
}
