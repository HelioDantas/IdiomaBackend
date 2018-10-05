package br.com.matrix.idioma.config;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
}
