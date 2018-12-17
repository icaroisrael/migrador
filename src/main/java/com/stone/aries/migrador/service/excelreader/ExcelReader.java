package com.stone.aries.migrador.service.excelreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.stone.aries.migrador.service.excelreader.planilha.Coluna;
import com.stone.aries.migrador.service.excelreader.planilha.Linha;
import com.stone.aries.migrador.service.excelreader.planilha.Planilha;

public class ExcelReader {

	public Planilha loadPlanilha(MultipartFile fileTeste) throws IOException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(fileTeste.getInputStream());

		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter dataFormatter = new DataFormatter();
		
		Planilha p = new Planilha();
		boolean cabecalho = true;
		List<String> listCabecalhos = new ArrayList<String>();
		for (Row row : sheet) {
			
			Linha linha = new Linha();
			
			int iCabecalho = 0;
			for (Cell cell : row) {
				
				String cellValue = dataFormatter.formatCellValue(cell);
				
				if (cabecalho) {
					listCabecalhos.add(cellValue);
				}
				else {
					linha.addColuna(new Coluna(listCabecalhos.get(iCabecalho), cellValue));
					p.addLinha(linha);
				}
				
				iCabecalho++;
			}
			cabecalho = false;
		}
		
		workbook.close();
		
		return p;
	}

}
