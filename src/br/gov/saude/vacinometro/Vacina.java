package br.gov.saude.vacinometro;

public class Vacina {
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
