package com.stone.aries.migrador.service.excelreader.planilha;

public class Coluna {

	private String header;
	private String value;

	public Coluna(String header, String value) {
		this.header = header;
		this.value = value;
	}

	public String getHeader() {
		return header;
	}

	public String getValue() {
		return value;
	}

}