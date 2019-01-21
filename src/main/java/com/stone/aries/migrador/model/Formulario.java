package com.stone.aries.migrador.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Formulario {
	
	@Id
	private String id;
	private List<Pergunta> perguntas;
	
	public Formulario() {
		
	}
	
	public Formulario(List<Pergunta> pergunta) {
		this.perguntas = pergunta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Pergunta não pode ser vazio")
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPergunta(List<Pergunta> pergunta) {
		this.perguntas = pergunta;
	}

}
