package entidades;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {}
	
	public ContaPoupanca(int agencia, String titular, String cpf) {
		super(agencia, titular, cpf);
		this.setTipo(tipoDeConta.POUPANCA);
	}

	@Override
	public String sacar(double valor) throws SaldoIndisponivelException {
		double juros = valor * 0.02;
		if (valor + juros > this.getSaldo()) {
			throw new SaldoIndisponivelException();
		}
		this.setSaldo(this.getSaldo() - (valor + juros));
		return "\nSaque realizado com sucesso!";
	}

}
