package com.stone.aries.migrador.service.excelreader.planilha;

import java.util.ArrayList;
import java.util.List;

public class Linha {
	
	private int index = -1;

	private List<Coluna> colunas = new ArrayList<Coluna>();

	public void addColuna(Coluna coluna) {
		this.colunas.add(coluna);
	}
	
	public void moveParaPrimeiraColuna() {
		this.index = -1;
	}
	
	public Coluna posicaoColunaAtual() {
		return this.colunas.get(this.index);
	}

	public Coluna proximaColuna() {
		return this.colunas.get(++this.index);
	}

	public boolean existeProximaColuna() {
		if ((this.index + 1) < this.colunas.size()) {
			return true;
		} else {
			return false;
		}
	}
}
