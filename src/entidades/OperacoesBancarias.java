package entidades;

public interface OperacoesBancarias {
	
	public String sacar(double valor) throws SaldoIndisponivelException;
	public String depositar(double valor);
	public String consultar(double valor);

}
