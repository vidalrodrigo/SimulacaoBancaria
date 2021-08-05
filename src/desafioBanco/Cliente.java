package desafioBanco;

public class Cliente extends Pessoa{
	
	private Conta conta;
	
	public Cliente() {
		
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void saldo(double valor) {
		conta.setSaldo(valor);
	}
	
	
	
}
