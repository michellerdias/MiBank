package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void mains(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("------------------------------------------------------");
		System.out.println("-----------------Bem vindos ao MiBank-----------------");
		System.out.println("------------------------------------------------------");
		System.out.println("****** Selecione a opera��o que deseja realizar ******");
		System.out.println("------------------------------------------------------");
		System.out.println("|     Op��o 1 - Criar Conta     |");
		System.out.println("|     Op��o 2 - Depositar       |");
		System.out.println("|     Op��o 3 - Sacar           |");
		System.out.println("|     Op��o 4 - Transferir      |");
		System.out.println("|     Op��o 5 - Listar          |");
		System.out.println("|     Op��o 6 - Sair            |");
		
		int operacao = input.nextInt();
		switch(operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por utilizar nossa ag�ncia.");
			System.out.println("  MiBank: sempre pensando em voc�!  ");
			System.exit(0);
		
		default:
			System.out.println("Op��o Inv�lida");
			operacoes(); //Chama o menu opera��es
			break;
		}
	}
	
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCPF: ");
		String cpf = input.next();
		
		System.out.println("\nEmail: ");
		String email = input.next();
		
		Usuario usuario = new Usuario(nome, cpf, email);
		Conta conta = new Conta(usuario);
		
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		
		operacoes();
		
	}
	//M�todo Encontrar Conta
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for (Conta c: contasBancarias) { //Conta c dentro de contasBanc�rias
				if(c.getNumeroConta() == numeroConta) { //Se o n�mero digitado for uma conta existente
				conta = c; //utilizaremos a conta c (inserida pelo usu�rio).
				}
			}
		}
		return conta;
	}
	
	//M�todo Depositar;
	public static void depositar() {
		System.out.println("N�mero da conta para dep�sito: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) { //verificar se a conta foi encontrada (se existe mesmo)
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito); //chama o m�todo depositar
			System.out.println("Valor depositado com sucesso!");
			} else {
				System.out.println("  Conta n�o encontrada.  ");
			}
			operacoes();
		}
	
	public static void sacar() {
		System.out.println("N�mero da conta: "); //Pede conta
		int numeroConta = input.nextInt(); //Grava Conta
	
		Conta conta = encontrarConta(numeroConta); //Verifica se existe
		
		if (conta != null) { //se a conta for diferente de null (se ela existe mesmo)
			System.out.println("Qual valor deseja sacar? "); //Pede o valor do dep�sito
			Double valorSaque = input.nextDouble(); //Grava o valor do dep�sito
			conta.sacar(valorSaque); //chama o m�todo sacar - Saca
			} else {
				System.out.println("  Conta n�o encontrada.  ");
			}
			operacoes();
	}
	public static void transferir() {
		System.out.println("N�mero da conta do Remetente: "); //Pede conta
		int numeroContaRemetente = input.nextInt(); //Grava Conta
		
		Conta contaRemetende = encontrarConta(numeroContaRemetente);
		
		if (contaRemetende != null) { //Se a conta remetente existir
			System.out.println("N�mero da conta do Destinat�rio: "); //Eu pe�o a conta de quem vai receber
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) { //Se a Conta Destinat�rio existir
				System.out.println("Valor da Transfer�ncia: "); //Pede o valor da transfer�ncia
				Double valor = input.nextDouble();
				
				contaRemetende.transferir(contaDestinatario, valor);
				//chama o m�todo transferir (que est� na Classe Conta)
			}else {
				System.out.println("A conta para dep�sito n�o foi encontrada.");
			}
		}else {
			System.out.println("Sua conta n�o foi encontrada.");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("N�o h� contas cadastradas.");
		}
		operacoes();
	}
}