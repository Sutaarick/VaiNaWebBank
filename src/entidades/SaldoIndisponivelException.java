package entidades;

public class SaldoIndisponivelException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "\nSaldo indisponivel!!";
	}

}
