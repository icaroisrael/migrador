package com.stone.aries.migrador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.aries.migrador.model.Formulario;
import com.stone.aries.migrador.repository.FormularioRepository;
import com.stone.aries.migrador.service.FormularioService;

@Service
public class FormularioServiceImpl implements FormularioService {

	@Autowired
	private FormularioRepository formularioRepository;
	
	@Override
	public List<Formulario> listarTodos() {
		return this.formularioRepository.findAll();
	}

	@Override
	public Formulario cadastrar(Formulario formulario) {
		return this.formularioRepository.save(formulario);
	}

	@Override
	public Formulario atualizar(Formulario formulario) {
		return this.formularioRepository.save(formulario);
	}

	@Override
	public void remover(String id) {
		this.formularioRepository.deleteById(id);
	}

}
