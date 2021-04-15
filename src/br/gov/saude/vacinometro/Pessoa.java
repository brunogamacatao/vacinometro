package br.gov.saude.vacinometro;

public class Pessoa {
	private String cpf;
	private Vacina vacinaQueTomou;
	private int qtdDeDosesQueTomou;

	public Pessoa(String cpf, Vacina vacinaQueTomou) {
		this.cpf = cpf;
		this.vacinaQueTomou = vacinaQueTomou;
		this.qtdDeDosesQueTomou = 0;
	}
	
	public void vacinar() {
		this.qtdDeDosesQueTomou++;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Vacina getVacinaQueTomou() {
		return vacinaQueTomou;
	}

	public void setVacinaQueTomou(Vacina vacinaQueTomou) {
		this.vacinaQueTomou = vacinaQueTomou;
	}

	public int getQtdDeDosesQueTomou() {
		return qtdDeDosesQueTomou;
	}

	public void setQtdDeDosesQueTomou(int qtdDeDosesQueTomou) {
		this.qtdDeDosesQueTomou = qtdDeDosesQueTomou;
	}
}
