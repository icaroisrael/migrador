package com.stone.aries.migrador.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.stone.aries.migrador.model.Formulario;
import com.stone.aries.migrador.model.Pergunta;
import com.stone.aries.migrador.service.FormularioService;
import com.stone.aries.migrador.service.PerguntaService;
import com.stone.aries.migrador.service.StorageService;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	
	@Autowired
	private FormularioService formularioService;
	
	@Autowired
	private PerguntaService perguntaService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {
		return "uploadForm";
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
			throws InvalidFormatException, IOException {

		List<Formulario> lista = storageService.store(file);
		for (Formulario formulario : lista) {
			for (Pergunta pergunta : formulario.getPerguntas()) {
				perguntaService.cadastrar(pergunta);
			}
			formularioService.cadastrar(formulario);
		}
		
		redirectAttributes.addFlashAttribute("message",
				"Upload realizado do arquivo " + file.getOriginalFilename() + "!");
		return "redirect:/";
	}

}
