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

	@Override
	public String sacar(double valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String depositar(double valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultar(double valor) {
		// TODO Auto-generated method stub
		return null;
	}

}
