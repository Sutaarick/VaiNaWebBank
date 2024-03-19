package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;
import entidades.SaldoIndisponivelException;
import entidades.tipoDeConta;

public class SistemaBancarioControlador {

	private static List<Conta> contas = new ArrayList<Conta>();
	
	public static String criarNovaConta(Scanner sc) {
		Boolean loop = true;
		while(loop) {
			try {	
				System.out.println("Tipo de conta? (Poupança/Corrente)");
				String tipo = sc.next();
				System.out.println("Agencia: ");
				int agencia = sc.nextInt();
				System.out.println("Nome do Titular: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.println("CPF: ");
				String cpf = sc.next();
				
				Conta novaConta = retornarContaDoTipoCerto(tipo, agencia, nome, cpf);
				novaConta.setNumeroDeConta(contas);
				contas.add(novaConta);
				loop = false;
			} catch (Exception e) {
				e.getStackTrace();
				System.out.println("houve um erro ao criar a conta!\n"
						+ "por favor confira se todas as informações estão\n"
						+ "preenchidas corretamente!");
			}			
		}
		return "Conta criada com sucesso!";
	}
	
	public static void sacar(int numeroDeConta, double valor) {
		Conta conta = acharConta(numeroDeConta);
		if (conta != null) {
			try {
				System.out.println(conta.sacar(valor));
				System.out.println(conta.consultar());
			} catch (SaldoIndisponivelException e) {
				System.out.println(e.getMessage());
			}
		} else { System.out.println("\nConta inexistente!!!"); }				
	}
	
	public static void depositar(int numeroDeConta, double valor) {
		Conta conta = acharConta(numeroDeConta);
		if (conta != null) {
			System.out.println(conta.depositar(valor));
			System.out.println(conta.consultar());
		} else { System.out.println("\nConta inexistente!!!"); }
	}
	
	public static void listarContas() {
		if (contas.size() == 0) {
			System.out.println("\nNenhuma conta encontrada!!!");
		}		
		for (Conta conta : contas) {
			System.out.println(conta);
		}
	}
	
	public static String consultarConta(int numeroDeConta) {
		Conta conta = acharConta(numeroDeConta);
		if (conta != null) {
			return	"\nAgencia: "+ conta.getAgencia() +"\n"+
						"Titular: "+ conta.getTitular() +"\n"+
						"CPF: "+ conta.getCpf() +"\n"+
						"Saldo: R$"+ String.format("%.2f", conta.getSaldo()) +"\n";
		}
		return "\nConta inexistente!!!";
	}
	
	public static Conta acharConta(int numeroDeConta) {
		for (Conta conta : contas) {
			if (conta.getNumeroDeConta() == numeroDeConta)
				return conta;
		}
		return null;
	}

	public static void verificarCredito(int numeroDeConta) {
		Conta conta = acharConta(numeroDeConta);
		if (conta == null) {
			System.out.println("\nConta inexistente!!!");			
		} else if (conta.getTipo() != tipoDeConta.CORRENTE) {
			System.out.println("\nEstá conta não é uma conta corrente!!!");
		} else {
			ContaCorrente contaCorrente = (ContaCorrente) conta;
			System.out.println("\nVocê possui: R$" + String.format("%.2f", contaCorrente.getCredito()) + " de Credito");
		}
		
	}
	
	private static Conta retornarContaDoTipoCerto(String tipo, int agencia, String titular, String cpf) {
		if (tipo.toLowerCase().equals("poupança")) { 
			return new ContaPoupanca(agencia, titular, cpf);
		} else if (tipo.toLowerCase().equals("corrente")) {
			return new ContaCorrente(agencia, titular, cpf, Math.random() * 1000);
		}
		return null;
	}

}
