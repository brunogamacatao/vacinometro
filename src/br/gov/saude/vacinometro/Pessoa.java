package br.gov.saude.vacinometro;

import java.io.Serializable;

//implements Serializable => significa que a classe é GRAVÁVEL
public class Pessoa implements Serializable {
	private String cpf;
	private Vacina vacinaQueTomou;
	private int qtdDeDosesQueTomou;

	public Pessoa(String cpf, Vacina vacinaQueTomou) {
		this.cpf = cpf;
		this.vacinaQueTomou = vacinaQueTomou;
		this.qtdDeDosesQueTomou = 0;
	}
	
	public void vacinar() throws Exception {
		// Verificando se a pessoa ainda pode se vacinar
		// Se a quantidade de doses que tomou for menor que a qtd máxima de doses da vacina
		if (this.qtdDeDosesQueTomou < this.vacinaQueTomou.getQtdDeDoses()) {
			this.qtdDeDosesQueTomou++; // Incrementa o contador de doses => vacina feita com sucesso!
		} else {
			// AQUI EU TENHO QUE LANÇAR UM ERRO !!!
			throw new Exception("Essa pessoa já tomou o número total de doses");
		}
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
