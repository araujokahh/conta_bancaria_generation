package conta;

import java.util.Scanner;

import util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("            BANCO DO BRAZIL COM Z            ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("       1- Criar conta                        ");
			System.out.println("       2- Listar todas as contas             ");
			System.out.println("       3- Buscar conta por número            ");
			System.out.println("       4- Atualizar dados da conta           ");
			System.out.println("       5- Apagar conta                       ");
			System.out.println("       6- Sacar                              ");
			System.out.println("       7- Depositar                          ");
			System.out.println("       8- Transferir valores entre contas    ");
			System.out.println("       9- Sair                               ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("Digite a opção desejada:                     " + Cores.TEXT_RESET);
			System.out.println("                                             ");

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Criar conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +"Listar todas as contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Consultar dados da conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +"Atualizar dados da conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +"Apagar a conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +"Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +"Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT  +"Transferência entre contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +"\nOpção inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Karina Camargo Araujo - karinaa@genstudents.org");
		System.out.println("https://github.com/araujokahh");
		System.out.println("*********************************************");

	}
}
