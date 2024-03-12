package entidades;

public class ContaCorrente extends Conta {
	
	private double credito;
	
	public ContaCorrente() {
		
	}

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
	public String sacar(double valor) throws SaldoIndisponivelException {
		if (valor < this.getSaldo()) {
			throw new SaldoIndisponivelException();
		}
		return "Saque realizado com sucesso!";
	}
}
