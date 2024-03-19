package aplicacao;

import java.util.Scanner;

import controlador.SistemaBancarioControlador;

public class Main {
	public static void main(String[] args) {
		
		int			opcao;
		boolean	loop = true;
		Scanner	sc = new Scanner(System.in);
		
		System.out.println("BEM VINDE AO VAINAWEBANK!!!");
		
		while (loop) {
			try {	
				System.out.println("\nQual operação deseja realizar?");
				System.out.println("\n1- Criar conta\n2- Listar contas\n3- Consultar\n4- Saque\n5- Deposito\n6- Credito\n7- Sair");
				opcao = sc.nextInt();
				switch (opcao) {
					case 1: {
						System.out.println(SistemaBancarioControlador.criarNovaConta(sc));
						break;
					}
					case 2: {
						SistemaBancarioControlador.listarContas();
						break;
					}
					case 3: {
						System.out.println("Numero da Conta: ");
						int numeroDeConta = sc.nextInt();
						System.out.println(SistemaBancarioControlador.consultarConta(numeroDeConta));
						break;
					}
					case 4: {
						System.out.println("Numero da Conta: ");
						int numeroDeConta = sc.nextInt();
						System.out.println("Valor: ");
						double valor = sc.nextDouble();
						SistemaBancarioControlador.sacar(numeroDeConta, valor);
						break;
					}
					case 5: {
						System.out.println("Numero da Conta: ");
						int numeroDeConta = sc.nextInt();
						System.out.println("Valor: ");
						double valor = sc.nextDouble();
						SistemaBancarioControlador.depositar(numeroDeConta, valor);
						break;					
					}
					case 6: {
						System.out.println("Numero da Conta: ");
						int numeroDeConta = sc.nextInt();
						SistemaBancarioControlador.verificarCredito(numeroDeConta);
						break;
					}
					case 7: {
						System.out.println("Volte Sempre!!!");
						loop = false;
					}
				}
				
			} catch (Exception e) {
				System.out.println("Opção invalida!!!");
			}
		}
		
		sc.close();
	}
}
