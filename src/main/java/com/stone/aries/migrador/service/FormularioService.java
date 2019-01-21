package com.stone.aries.migrador.service;

import java.util.List;

import com.stone.aries.migrador.model.Formulario;

public interface FormularioService {
	List<Formulario> listarTodos();
	Formulario cadastrar(Formulario formulario);
	Formulario atualizar(Formulario formulario);
	void remover(String id);
}
