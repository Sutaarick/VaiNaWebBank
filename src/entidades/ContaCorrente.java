package entidades;

public class ContaCorrente extends Conta {
	
	private double credito;

	public ContaCorrente(int agencia, String titular, String cpf) {
		super(agencia, titular, cpf);
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

}
