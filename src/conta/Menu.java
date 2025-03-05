package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");		
				
		while(true)
		{
			
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND 
					         + "*********************************************************************");
			System.out.println("                                                                     ");
			System.out.println("                   BANCO DO BRAZIL COM Z                             ");
			System.out.println("                                                                     ");
			System.out.println("*********************************************************************");
			System.out.println("                                                                     ");
			System.out.println("                1 - Criar Conta                                      ");
			System.out.println("                2 - Listar todas as Contas                           ");
			System.out.println("                3 - Buscar Conta por Numero                          ");
			System.out.println("                4 - Atualizar Dados da Conta                         ");
			System.out.println("                5 - Apagar Conta                                     ");
			System.out.println("                6 - Sacar                                            ");
			System.out.println("                7 - Depositar                                        ");
			System.out.println("                8 - Transferir valores entre Contas                  ");
			System.out.println("                9 - Sair                                             ");
			System.out.println("                                                                     ");
			System.out.println("*********************************************************************");
			System.out.println("Entre com a opção desejada:                                          ");
			System.out.println("                                                                     ");
			
			try {
				opcao = scan.nextInt();
			
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				scan.nextLine();
				opcao = 0;
				
			}
			
			if(opcao == 9) {		
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui");
				sobre();
				scan.close();
				System.exit(0);				
			}
			
			
			switch(opcao) {	
			case 1: 
				System.out.println(Cores.TEXT_WHITE_BOLD +"Criar Conta\n\n");
				System.out.println("Digite o Número da Agência: ");
				agencia = scan.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				scan.skip("\\R?");
				titular = scan.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = scan.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scan.nextFloat();
				
				switch(tipo) {
				case 1 -> {					
					System.out.println("Digite o limite de Crédito (R$): ");
					limite = scan.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = scan.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					
					}
				}
				
				KeyPress();
				break;				
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Listar todas as Contas\n\n");
				contas.listarTodas();
				KeyPress();
				break;				
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Consultar dados da conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();
				
				contas.procurarPorNumero(numero);
				
				KeyPress();
				break;				
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar dados da Conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null ) {
					tipo = buscaConta.getTipo();
					
				System.out.println("Digite o Numero da Agência: ");
				agencia = scan.nextInt();
				
				System.out.println("Digite o Nome do Titular: ");
				scan.skip("\\R?");
				titular = scan.nextLine();
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scan.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito(R$): ");
					limite = scan.nextFloat();
					contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = scan.nextInt();
					
					contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
				}
				default -> {
					System.out.println("Tipo de conta inválida!");
				}
				}
				
				}else {
					System.out.println("A conta não foi encontrada!");
				}
				
				KeyPress();
				break;				
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Apagar a Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();
				
				contas.deletar(numero);
				
				KeyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Saque\n\n");
				System.out.println("Digite o Número da conta: ");
				numero = scan.nextInt();
				
				do {
					System.out.println("Digite o valor do Saque (R$): ");
					valor = scan.nextFloat();
					
				}while(valor <= 0);
				
				contas.sacar(numero, valor);
				
				KeyPress();
				break;				
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Deposito\n\n");
				System.out.println("Digite o Número da conta: ");
				numero = scan.nextInt();
				
				do {
					System.out.println("Digite o valor do Depósito (R$): ");
					valor = scan.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
					
				KeyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Transferência entre Contas\n\n");
				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = scan.nextInt();
				
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = scan.nextInt();
				
				do {
					System.out.println("Digite o valor da Transferência (R$): ");
					valor = scan.nextFloat();
					
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				KeyPress();
				break;				
			default:
				System.out.println(Cores.TEXT_RED_BOLD +"\nOpção Inválida");
				
				KeyPress();
				break;
			}			
			
		}
		
	}
	
	public static void sobre() {
	
		System.out.println("*********************************************************************");
		System.out.println("Projeto Desenvolvido por: Alexania Toma");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************************");		
		
	}
	
	public static void KeyPress()
	{
		try {
			System.out.println(Cores.TEXT_RESET + "\n\n Pressione Enter para continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
