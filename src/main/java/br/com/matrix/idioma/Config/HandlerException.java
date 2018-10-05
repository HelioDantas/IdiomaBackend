package br.com.matrix.idioma.model;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handlerResourceNotFoundException(RuntimeNotFoundException exception, WebRequest request)
	{
		ExceptionDetails erro = new ExceptionDetails();
		erro.setDetail(exception.getMessage());
		erro.setDevMensagem(exception.getClass().getName());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setTimeStamp(LocalDate.now());
		erro.setTitle(PAGE_NOT_FOUND_LOG_CATEGORY);
		
		return handlerExceptionInternal(exception, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
}
