package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {
	
	public static void main(String[] args) {
		
		
		//Teste da Classe Conta
		
		Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f );
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		
		
		Scanner scan = new Scanner(System.in);
		
		int opcao;
		
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
			
			opcao = scan.nextInt();
			
			if(opcao == 9)
			{
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui");
				sobre();
				scan.close();
				System.exit(0);				
			}
			
			switch(opcao) 
			{	
			case 1: 
				System.out.println(Cores.TEXT_WHITE_BOLD +"Criar Conta\n\n");
				
				break;				
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Listar todas as Contas\n\n");
				
				break;				
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Consultar dados da conta - por número\n\n");
				
				break;				
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar dados da Conta\n\n");
				
				break;				
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Apagar a Conta\n\n");
				
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Saque\n\n");
				
				break;				
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Deposito\n\n");
				
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Transferência entre Contas\n\n");
				
				break;				
			default:
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nOpção Inválida");
				break;
			}
			
			
		}
		
	}
	
	public static void sobre() 
	{
		System.out.println("*********************************************************************");
		System.out.println("Projeto Desenvolvido por: Alexania Toma");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************************");		
		
	}

}
