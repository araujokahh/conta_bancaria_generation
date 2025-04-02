package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Beatriz Camargo", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Adriana Camargo", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Karina Camargo", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Pamela Camargo", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {

			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_WHITE_BACKGROUND);
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

			// trata a entrada de dados na variavel 'opcao'. Se a pessoa digitar outra coisa
			// que não seja um número inteiro, receberá a mensagem de exceção e reiniciará a
			// variável com o valor 0
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Criar conta\n\n");

				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da conta(1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da conta: R$ ");
				saldo = leia.nextFloat();

				switch (tipo) {
				// -> é utilizado para Switch Expression, uma vaariação do SwitchCase mais
				// elegante pois pode ser escrito na mesma linha
				case 1 -> {
					System.out.println("Digite o Limite de crédito: R$ ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o dia do Aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(
						Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Listar todas as contas\n\n");
				contas.listarTodas();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
						+ "Consultar dados da conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(
						Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Atualizar dados da conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				var buscarConta = contas.buscarNaCollection(numero);

				if (buscarConta != null) {

					tipo = buscarConta.getTipo();

					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.println("Digite o saldo da conta: R$ ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito: R$ ");
						limite = leia.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}

					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));

					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}

				} else {
					System.out.println("A conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Apagar a conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Saque\n\n");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "Depósito\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Transferência entre contas\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "\nOpção inválida!\n");

				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar.");
			// Serve para ler a entrada via teclado/lê qual tecla foi digitada
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma techa diferente de enter!");
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
