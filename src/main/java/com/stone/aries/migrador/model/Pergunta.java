package com.stone.aries.migrador.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pergunta {
	
	@Id
	private String id;
	private String descricao;
	private String resposta;
	
	public Pergunta(String descricao, String resposta) {
		this.descricao = descricao;
		this.resposta = resposta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
