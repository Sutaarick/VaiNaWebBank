package entidades;

public class ContaCorrente extends Conta {
	
	private double credito;
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(int agencia, String titular, String cpf, double credito) {
		super(agencia, titular, cpf);
		this.credito = credito;
		this.setTipo(tipoDeConta.CORRENTE);
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	@Override
	public String sacar(double valor) throws SaldoIndisponivelException {
		if (valor > this.getSaldo()) {
			throw new SaldoIndisponivelException();
		}
		this.setSaldo(this.getSaldo() - valor);
		return "\nSaque realizado com sucesso!\n";
	}
}
