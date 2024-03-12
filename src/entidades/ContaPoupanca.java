package entidades;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {}
	
	public ContaPoupanca(int agencia, String titular, String cpf) {
		super(agencia, titular, cpf);
	}

	@Override
	public String sacar(double valor) throws SaldoIndisponivelException {
		double juros = valor * 0.02;
		if (valor < this.getSaldo() + juros) {
			throw new SaldoIndisponivelException();
		}
		return "Saque realizado com sucesso!";
	}

}
