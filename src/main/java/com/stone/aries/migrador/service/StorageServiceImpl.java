package com.stone.aries.migrador.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.stone.aries.migrador.service.excelreader.ExcelReader;
import com.stone.aries.migrador.service.excelreader.planilha.Coluna;
import com.stone.aries.migrador.service.excelreader.planilha.Linha;
import com.stone.aries.migrador.service.excelreader.planilha.Planilha;

@Service
public class StorageServiceImpl implements StorageService {

	@Override
	public void store(MultipartFile file) throws InvalidFormatException, IOException {
		
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
			}
			System.out.println();			
		}
	}

}
