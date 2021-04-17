package br.gov.saude.vacinometro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Vacinometro {
	// 1. Criar um arraylist para armazenar as vacinas
	private ArrayList<Vacina> vacinas;
	private ArrayList<Pessoa> pessoas;
	
	// Construtor da classe Vacinometro sem argumentos (no args)
	public Vacinometro() {
		vacinas = new ArrayList<>();
		pessoas = new ArrayList<>();
		carregar();
	}
	
	public void exibirMenu() {
		System.out.println("************************************");
		System.out.println("*            VACINÔMETRO           *");
		System.out.println("************************************");
		System.out.println("* 1. Cadastrar uma vacina 💉       *");
		System.out.println("* 2. Listar as vacinas             *");
		System.out.println("* 3. Cadastrar uma pessoa 👨       *");
		System.out.println("* 4. Listar as pessoas 🧑‍🤝‍🧑          *");
		System.out.println("* 5. Vacinar 💉                    *");
		System.out.println("* 9. Sair                          *");
		System.out.println("************************************");
	}
	
	public void executar() {
		while (true) {
			exibirMenu();
			
			// Lendo a opção a partir do teclado
			int opcao = lerOpcao();
			
			// Executando ações com base na opção escolhida pelo usuário
			if (opcao == 1) { // Cadastrar uma vacina
				cadastrarVacina();
				salvar();
			} else if (opcao == 2) { // Listar as vacinas cadastradas
				listarVacinas();
			} else if (opcao == 3) { // Cadastrar uma pessoa
				cadastrarPessoa();
				salvar();
			} else if (opcao == 4) { // Listar as pessoas cadastradas
				listarPessoas();
			} else if (opcao == 5) {
				vacinar();
				salvar();
			} else if (opcao == 9) {
				// Sair do sistema
				break; // saio do laço principal
			} else {
				// Opção inválida
				System.out.println("Opção inválida !");
			} // fim do if das ações
			
		}
	}
	
	public void vacinar() {
		System.out.print("Digite o cpf da pessoa: ");
		String cpf = Teclado.leString(); // o cpf da pessoa que foi digitado
		
		Pessoa pessoaQueSeraVacinada = null;
		
		for (Pessoa p : pessoas) {
			if (p.getCpf().equals(cpf)) { // se o cpf da pessoa p for igual ao cpf digitado
				pessoaQueSeraVacinada = p; // achei a pessoa que será vacinada
				break; // já achei a pessoa, não preciso ir até o final do for
			}
		}
		
		if (pessoaQueSeraVacinada != null) {
			try {
				// Vou TENTAR vacinar
				pessoaQueSeraVacinada.vacinar();
				// se deu tudo certo, exibe uma mensagem de sucesso
				System.out.println("Pessoa vacinada com sucesso !");
			} catch (Exception e) {
				// se deu uma exceção
				System.out.println("Ocorreu um erro: " + e.getMessage()); // exibe uma mensagem
			}
		} else {
			System.out.println("Não foi encontrada uma pessoa com o cpf informado");
		}
	}
	
	public void cadastrarPessoa() {
		System.out.print("Digite o cpf da pessoa: ");
		String cpf = Teclado.leString(); // o cpf da pessoa que foi digitado
		System.out.println("Vacinas disponíveis: ");
		int i = 0;
		for (Vacina v : vacinas) { // exibindo a lista de vacinas cadastradas para escolher
			System.out.println(i + " - " + v.getNome());
			i++;
		}
		System.out.print("Escolha a vacina: ");
		int indiceVacina = Teclado.leInt();
		
		try {
			// Vou tentar acessar a vacina escolhida pelo usuário
			Vacina vacinaEscolhida = vacinas.get(indiceVacina); // a vacina escolhida
			// Eu posso criar um objeto da classe Pessoa
			Pessoa novaPessoa = new Pessoa(cpf, vacinaEscolhida);
			pessoas.add(novaPessoa); // Adiciono a nova pessoa ao array list de pessoas
		} catch (Exception e) {
			// O usuário escolheu uma vacina que não existe
			System.out.println("Você digitou um código inválido para a vacina");
		}
	}
	
	public void listarPessoas() {
		for (Pessoa p : pessoas) {
			System.out.println(p.getCpf() + " - " + p.getVacinaQueTomou().getNome() + 
					           " - Tomou " + p.getQtdDeDosesQueTomou() + " doses");
		}
	}
	
	public int lerOpcao() {
		System.out.print("* Digite a sua opção: ");
		int opcao = Teclado.leInt();
		return opcao;
	}
	
	public void cadastrarVacina() {
		System.out.print("Digite o nome da vacina: ");
		String nome = Teclado.leString();
		System.out.print("Qual a quantidade de doses necessária: ");
		int qtdDoses = Teclado.leInt();
		Vacina novaVacina = new Vacina(nome, qtdDoses);
		vacinas.add(novaVacina);
	}
	
	public void listarVacinas() {
		for (Vacina v : vacinas) {
			System.out.println(v.getNome() + " - precisa tomar " + v.getQtdDeDoses() + " doses");
		}
	}
	
	public void salvar() {
		System.out.println("Salvando os dados ...");
		try {
			// Salvando as vacinas em um arquivo
			ObjectOutputStream oosVacinas = new ObjectOutputStream(new FileOutputStream(new File("vacinas.dat")));
			oosVacinas.writeObject(vacinas);
			oosVacinas.close();
			
			// Salvando as pessoas em um arquivo
			ObjectOutputStream oosPessoas = new ObjectOutputStream(new FileOutputStream(new File("pessoas.dat")));
			oosPessoas.writeObject(pessoas);
			oosPessoas.close();
		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		}
	}
	
	public void carregar() {
		System.out.println("Carregando os dados ...");
		try {
			ObjectInputStream oisVacinas = new ObjectInputStream(new FileInputStream(new File("vacinas.dat")));
			vacinas = (ArrayList<Vacina>)oisVacinas.readObject();
			oisVacinas.close();

			ObjectInputStream oisPessoas = new ObjectInputStream(new FileInputStream(new File("pessoas.dat")));
			pessoas = (ArrayList<Pessoa>)oisPessoas.readObject();
			oisPessoas.close();
		} catch (Exception e) {
			System.out.println("Erro ao carregar: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// 1. Criar um objeto da classe Vacinometro
		Vacinometro v = new Vacinometro();
		// 2. Executar o vacinometro
		v.executar();
	}
}
