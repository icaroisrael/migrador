package com.stone.aries.migrador.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.stone.aries.migrador.model.Formulario;
import com.stone.aries.migrador.model.Pergunta;
import com.stone.aries.migrador.service.StorageService;
import com.stone.aries.migrador.service.excelreader.ExcelReader;
import com.stone.aries.migrador.service.excelreader.planilha.Coluna;
import com.stone.aries.migrador.service.excelreader.planilha.Linha;
import com.stone.aries.migrador.service.excelreader.planilha.Planilha;

@Service
public class StorageServiceImpl implements StorageService {

	@Override
	public List<Formulario> store(MultipartFile file) throws InvalidFormatException, IOException {
		List<Formulario> listaFormularios = new ArrayList<>();
		List<Pergunta> listaPerguntas = new ArrayList<>();
		
		ExcelReader r = new ExcelReader();
		Planilha planilha = r.loadPlanilha(file);

		// TODO implementacao provisoria para exemplo
		System.out.println("\n");
		while (planilha.existeProximaLinha()) {
			Linha linha = planilha.proximaLinha();
			
			while (linha.existeProximaColuna()) {
				Coluna c = linha.proximaColuna();
				System.out.println("Header:" + c.getHeader());
				System.out.println("Value:" + c.getValue());
				listaPerguntas.add(new Pergunta(c.getHeader(), c.getValue()));
			}
			
			if(listaPerguntas.size()>0) {
				listaFormularios.add(new Formulario(listaPerguntas));
				listaPerguntas = new ArrayList<>();
			}
			
			System.out.println();
		}
		return listaFormularios;
	}

}
