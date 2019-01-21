package com.stone.aries.migrador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stone.aries.migrador.model.Formulario;

public interface FormularioRepository extends MongoRepository<Formulario, String> {

}
