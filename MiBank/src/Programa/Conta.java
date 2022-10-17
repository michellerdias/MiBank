package Programa;

import utilitarios.Utils;

public class Conta {
	
	private static int accountcounter;
	
	private int numeroConta;
	private Usuario usuario;
	private Double saldo = 0.0;
	
	public Conta(Usuario usuario) {
		super();
		this.numeroConta = accountcounter;
		this.usuario = usuario;
		accountcounter += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nBank account: " + this.getNumeroConta() +
                "\nCliente: " + this.usuario.getNome() +
                "\nCPF: " + this.usuario.getCpf() +
                "\nEmail: " + this.usuario.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu dep�sito foi realizado com sucesso!");
		} else {
			System.out.println("N�o foi poss�vel realizar o dep�sito.");
		}
	}
	
	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Seu saque foi realizado com sucesso!");	
		} else {
			System.out.println("N�o foi poss�vel realizar o saque.");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transfer�ncia realizada com Sucesso!");
		} else {
			System.out.println("N�o � poss�vel realizar a transfer�ncia.");
		}
	}
	
	
}
