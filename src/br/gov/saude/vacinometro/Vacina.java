package br.gov.saude.vacinometro;

import java.io.Serializable;

// implements Serializable => significa que a classe é GRAVÁVEL
public class Vacina implements Serializable {
	private String nome;
	private int qtdDeDoses;

	public Vacina(String nome, int qtdDeDoses) {
		this.nome = nome;
		this.qtdDeDoses = qtdDeDoses;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdDeDoses() {
		return qtdDeDoses;
	}

	public void setQtdDeDoses(int qtdDeDoses) {
		this.qtdDeDoses = qtdDeDoses;
	}
}
