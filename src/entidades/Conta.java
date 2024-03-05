package entidades;

public abstract class Conta implements OperacoesBancarias {
	
	private int agencia;
	private String titular;
	private String cpf;
	private double saldo;
	
	public Conta(int agencia, String titular, String cpf) {
		this.agencia = agencia;
		this.titular = titular;
		this.cpf = cpf;
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
	
}
