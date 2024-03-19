package entidades;

public enum tipoDeConta {
	CORRENTE("Conta corrente"),
	POUPANCA("Conta poupança");
	
	private String nome;

	tipoDeConta(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
