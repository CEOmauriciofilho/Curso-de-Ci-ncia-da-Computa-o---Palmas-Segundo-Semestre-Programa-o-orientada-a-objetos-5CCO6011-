package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca extends GerenciamentoBiblioteca{
	//---------------------------------------------------------------------------------
	public static void main(String[] args) {
		ArrayList<Livro> ListaDeLivros = new ArrayList<>();
		ArrayList<Autor> ListaDeAutores = new ArrayList<>();
		ArrayList<Livro> ListaDeEmprestimos = new ArrayList<>();
		ArrayList<Livro> ListaDeLivrosRemovidos = new ArrayList<>();
		
		Scanner Entrada = new Scanner(System.in);

		short op = 0;
		do {
			System.out.printf("<_________________________>\n");
			System.out.printf("|EMPRESTIMO LIVRO (0)     |\n");
			System.out.printf("|GERENCIAR LIVROS (1)     |\n");
			System.out.printf("|DEVOLVER LIVRO (2)       |\n");
			System.out.printf("|SAIR DO SISTEMA (3)      |\n");
			System.out.printf("|_________________________|\n");
			op = Entrada.nextShort();
			Entrada.nextLine(); 
			switch (op) {
				case 0:
					emprestarLivro(ListaDeLivros, ListaDeEmprestimos, Entrada);
					break;
				case 1:
					gerenciarLivros(ListaDeLivros, ListaDeLivrosRemovidos, Entrada);
					break;
				case 2:
					devolverLivro(ListaDeLivros, Entrada);
					break;
				default:
					if (op != 3)
					System.out.printf("valor invalido\n");
			}
		} while (op != 3);
		System.out.println("\nFim da aplicação");
		Entrada.close();
	}

	
}