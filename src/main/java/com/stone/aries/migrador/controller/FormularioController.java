package com.stone.aries.migrador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.aries.migrador.model.Formulario;
import com.stone.aries.migrador.response.Response;
import com.stone.aries.migrador.service.FormularioService;	

@RestController
@RequestMapping(path = "/api/formulario")
public class FormularioController {
	
	@Autowired
	private FormularioService formularioService;
	
	@GetMapping("/listar")
	public ResponseEntity<Response<List<Formulario>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Formulario>>(this.formularioService.listarTodos()));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Response<Formulario>> cadastrar(@Valid @RequestBody Formulario formulario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Formulario>(erros));
		}
		return ResponseEntity.ok(new Response<Formulario>(this.formularioService.cadastrar(formulario)));
	}
	
	@PutMapping(path = "atualizar/{id}")
	public ResponseEntity<Response<Formulario>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Formulario formulario, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Formulario>(erros));
		}
		formulario.setId(id);
		return ResponseEntity.ok(new Response<Formulario>(this.formularioService.atualizar(formulario)));
	}
	
	@DeleteMapping(path = "remover/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.formularioService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
}
