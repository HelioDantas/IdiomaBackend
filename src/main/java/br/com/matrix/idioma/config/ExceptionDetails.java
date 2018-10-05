package br.com.matrix.idioma.config;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExceptionDetails{

	private String title;
	private int status;
	private String detail;
	private LocalDate timeStamp;
	private String DevMensagem;
}
