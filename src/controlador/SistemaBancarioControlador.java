package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;

public class SistemaBancarioControlador {

	private List<Conta> Contas = new ArrayList<Conta>();
	
	public String criarNovaConta(Scanner sc) {
		Boolean loop = true;
		while(loop) {
			try {	
				System.out.println("Tipo de conta? (Poupança/Corrente)");
				String tipo = sc.next();
				System.out.println("Agencia");
				int agencia = sc.nextInt();
				System.out.println("Nome do Titular: ");
				String nome = sc.next();
				System.out.println("Cpf");
				String cpf = sc.next();
				
				Conta novaConta = retornarContaDoTipoCerto(tipo, agencia, nome, cpf);
				novaConta.setNumeroDeConta(Contas);
				Contas.add(novaConta);
			} catch (Exception e) {
				
				System.out.println("houve um erro ao criar a conta!\n"
						+ "por favor confira se todas as informações estão\n"
						+ "preenchidas corretamente!");
			}			
		}
		return "Conta criada com sucesso!";
	}

	private Conta retornarContaDoTipoCerto(String tipo, int agencia, String titular, String cpf) {
		if (tipo.toLowerCase() == "poupança") { 
			return new ContaPoupanca(agencia, titular, cpf);
		} else if (tipo.toLowerCase() == "corrente") {
			return new ContaCorrente(agencia, titular, cpf);
		}
		return null;
	}
}
