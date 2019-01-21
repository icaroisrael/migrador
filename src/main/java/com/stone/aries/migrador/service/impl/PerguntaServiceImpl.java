package com.stone.aries.migrador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.aries.migrador.model.Pergunta;
import com.stone.aries.migrador.repository.PerguntaRepository;
import com.stone.aries.migrador.service.PerguntaService;

@Service
public class PerguntaServiceImpl implements PerguntaService {

	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Override
	public Pergunta cadastrar(Pergunta pergunta) {
		return this.perguntaRepository.insert(pergunta);
	}

}
