package entidades;

import java.util.List;

public abstract class Conta implements OperacoesBancarias {
	
	private int agencia;
	private String titular;
	private String cpf;
	private double saldo;
	private int numeroDeConta;
	private tipoDeConta tipo;
	
	public Conta() {	}
	
	public Conta(int agencia, String titular, String cpf) {
		this.agencia = agencia;
		this.titular = titular;
		this.cpf = cpf;
	}
	
	public String depositar(double valor) {
		this.setSaldo(valor);
		return "\nDeposito realizado com sucesso!";
	}

	public String consultar() {
		return "Você possui R$" + String.format("%.2f", this.getSaldo()) + "\n";
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroDeConta() {
		return numeroDeConta;
	}
	
	public void setNumeroDeConta(int numeroDeConta) {
		this.numeroDeConta = numeroDeConta;
	}
	
	public void setNumeroDeConta(List<Conta> contas) {
		if (contas.size() == 0) {
			this.numeroDeConta = 20240001;
		} else {
			this.numeroDeConta = contas.get(contas.size() - 1).numeroDeConta + 1;
		}
	}
	
	@Override
	public String toString() {
		return "\n" + titular + "\nAgencia: " + agencia + "\nConta: " + numeroDeConta + "\n" + tipo.getNome(); 
	}

	public tipoDeConta getTipo() {
		return tipo;
	}

	public void setTipo(tipoDeConta tipo) {
		this.tipo = tipo;
	}

	
}
