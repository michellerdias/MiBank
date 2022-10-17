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
		System.out.println("****** Selecione a operação que deseja realizar ******");
		System.out.println("------------------------------------------------------");
		System.out.println("|     Opção 1 - Criar Conta     |");
		System.out.println("|     Opção 2 - Depositar       |");
		System.out.println("|     Opção 3 - Sacar           |");
		System.out.println("|     Opção 4 - Transferir      |");
		System.out.println("|     Opção 5 - Listar          |");
		System.out.println("|     Opção 6 - Sair            |");
		
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
			System.out.println("Obrigado por utilizar nossa agência.");
			System.out.println("  MiBank: sempre pensando em você!  ");
			System.exit(0);
		
		default:
			System.out.println("Opção Inválida");
			operacoes(); //Chama o menu operações
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
	//Método Encontrar Conta
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for (Conta c: contasBancarias) { //Conta c dentro de contasBancárias
				if(c.getNumeroConta() == numeroConta) { //Se o número digitado for uma conta existente
				conta = c; //utilizaremos a conta c (inserida pelo usuário).
				}
			}
		}
		return conta;
	}
	
	//Método Depositar;
	public static void depositar() {
		System.out.println("Número da conta para depósito: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) { //verificar se a conta foi encontrada (se existe mesmo)
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito); //chama o método depositar
			System.out.println("Valor depositado com sucesso!");
			} else {
				System.out.println("  Conta não encontrada.  ");
			}
			operacoes();
		}
	
	public static void sacar() {
		System.out.println("Número da conta: "); //Pede conta
		int numeroConta = input.nextInt(); //Grava Conta
	
		Conta conta = encontrarConta(numeroConta); //Verifica se existe
		
		if (conta != null) { //se a conta for diferente de null (se ela existe mesmo)
			System.out.println("Qual valor deseja sacar? "); //Pede o valor do depósito
			Double valorSaque = input.nextDouble(); //Grava o valor do depósito
			conta.sacar(valorSaque); //chama o método sacar - Saca
			} else {
				System.out.println("  Conta não encontrada.  ");
			}
			operacoes();
	}
	public static void transferir() {
		System.out.println("Número da conta do Remetente: "); //Pede conta
		int numeroContaRemetente = input.nextInt(); //Grava Conta
		
		Conta contaRemetende = encontrarConta(numeroContaRemetente);
		
		if (contaRemetende != null) { //Se a conta remetente existir
			System.out.println("Número da conta do Destinatário: "); //Eu peço a conta de quem vai receber
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) { //Se a Conta Destinatário existir
				System.out.println("Valor da Transferência: "); //Pede o valor da transferência
				Double valor = input.nextDouble();
				
				contaRemetende.transferir(contaDestinatario, valor);
				//chama o método transferir (que está na Classe Conta)
			}else {
				System.out.println("A conta para depósito não foi encontrada.");
			}
		}else {
			System.out.println("Sua conta não foi encontrada.");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas.");
		}
		operacoes();
	}
}