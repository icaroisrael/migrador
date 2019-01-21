package com.stone.aries.migrador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stone.aries.migrador.model.Pergunta;

public interface PerguntaRepository extends MongoRepository<Pergunta, String> {

}
