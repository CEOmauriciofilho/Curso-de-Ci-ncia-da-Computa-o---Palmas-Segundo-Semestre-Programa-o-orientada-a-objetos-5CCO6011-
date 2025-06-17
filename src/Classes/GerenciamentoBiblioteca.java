package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoBiblioteca {
	public static void emprestarLivro(ArrayList<Livro> lista, ArrayList<Livro> emprestimos, Scanner entrada) {
		System.out.println("\n<-- Empréstimo de Livro -->");
		System.out.print("Digite o ID do livro: ");
		int id = entrada.nextInt();
		entrada.nextLine(); 

		for (Livro livro : lista) {
			if (livro.isDisponibilidade() && livro.getId() == id) {
				System.out.print("Digite o nome de quem está pegando emprestado: ");
				String nome = entrada.nextLine();
				System.out.print("Digite a data do empréstimo (ex: 17/06/2025): ");
				String data = entrada.nextLine();

				livro.setDisponibilidade(false);
				livro.setNomeDaPessoaQuePegouEmprestado(nome);
				livro.setDataDoUtimoEmprestimo(data);
				emprestimos.add(livro);
				System.out.println("Livro emprestado com sucesso!");
				return;
			}
		}
		System.out.println("Livro não encontrado ou indisponível.");
	}

	//---------------------------------------------------------------------------------
	public static void gerenciarLivros(ArrayList<Livro> lista, ArrayList<Livro> removidos, Scanner entrada) {
		short op = 0;
		do {
			System.out.println("\n<-- Gerenciar Livros -->");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Listar Livros");
			System.out.println("3 - Excluir Livro");
			System.out.println("4 - Voltar");
			op = entrada.nextShort();
			entrada.nextLine(); 

			switch (op) {
				case 1:
					cadastrarLivro(lista, entrada);
					break;
				case 2:
					listarLivros(lista);
					break;
				case 3:
					excluirLivro(lista, removidos, entrada);
					break;
				case 4:
					break;
				default:
					System.out.println("Opção inválida.");
			}
		} while (op != 4);
	}

	//---------------------------------------------------------------------------------
	public static void cadastrarLivro(ArrayList<Livro> lista, Scanner entrada) {
		System.out.println("\n<-- Cadastro de Livro -->");
		System.out.print("Digite o ID do livro: ");
		int id = entrada.nextInt();
		for (Livro livro : lista) {
			if (livro.getId() == id) {
				System.out.println("Erro: Já existe um livro com esse ID.");
				return;
			}
		}
		entrada.nextLine(); 
		System.out.print("Digite o título do livro: ");
		String titulo = entrada.nextLine();
		System.out.print("Digite a data de cadastro (ex: 17/06/2025): ");
		String dataCadastro = entrada.nextLine();
		System.out.print("Digite o nome do autor: ");
		String autor = entrada.nextLine();

		Livro novoLivro = new Livro(id, titulo, dataCadastro, autor);
		lista.add(novoLivro);
		System.out.println("Livro cadastrado com sucesso!");
	}

	//---------------------------------------------------------------------------------
	public static void listarLivros(ArrayList<Livro> lista) {
		System.out.println("\n<-- Lista de Livros -->");
		for (Livro livro : lista) {
			System.out.println("ID: " + livro.getId() +
							   " | Título: " + livro.getTitulo() +
							   " | Disponível: " + (livro.isDisponibilidade() ? "Sim" : "Não"));
		}
		if (lista.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
		}
	}

	//---------------------------------------------------------------------------------
	public static void devolverLivro(ArrayList<Livro> lista, Scanner entrada) {
		System.out.println("\n<-- Devolução de Livro -->");
		System.out.print("Digite o ID do livro a devolver: ");
		int id = entrada.nextInt();
		entrada.nextLine(); 

		for (Livro livro : lista) {
			if (!livro.isDisponibilidade() && livro.getId() == id) {
				livro.setDisponibilidade(true);
				livro.setNomeDaPessoaQuePegouEmprestado(null);
				System.out.println("Livro devolvido com sucesso!");
				return;
			}
		}
		System.out.println("Livro não encontrado ou já está disponível.");
	}

public static void excluirLivro(ArrayList<Livro> lista, ArrayList<Livro> removidos, Scanner entrada) {
	System.out.println("\n<-- Excluir Livro -->");
	System.out.print("Digite o ID do livro a ser excluído: ");
	int id = entrada.nextInt();
	entrada.nextLine(); 

	for (int i = 0; i < lista.size(); i++) {
		Livro livro = lista.get(i);
		if (livro.getId() == id) {
			System.out.printf("Digite a senha da biblioteca para excluir\n");
			String senha = entrada.nextLine();
			if(senha.equals( livro.getSenhaDaBiblioteca())) {
			removidos.add(livro);     
			lista.remove(i);          
			System.out.println("Livro excluído e movido para a lista de extraviados/removidos.");
			
			}
			return;
		}
	}
	System.out.println("Livro com o ID informado não foi encontrado.");
}

}
