package com.stone.aries.migrador.service.excelreader.planilha;

import java.util.ArrayList;
import java.util.List;

public class Planilha {

	private int index = -1;

	private List<Linha> linhas = new ArrayList<Linha>();

	public void addLinha(Linha linha) {
		this.linhas.add(linha);
	}

	public void moveParaPrimeiraLinha() {
		this.index = -1;
	}
	
	public Linha posicaoLinhaAtual() {
		return this.linhas.get(this.index);
	}

	public Linha proximaLinha() {
		return this.linhas.get(++this.index);
	}

	public boolean existeProximaLinha() {
		if ((this.index + 1) < this.linhas.size()) {
			return true;
		} else {
			return false;
		}
	}
}
