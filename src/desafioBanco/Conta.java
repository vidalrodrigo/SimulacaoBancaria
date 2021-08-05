package desafioBanco;

public class Conta {
	
	private int numAgencia;
	private int numConta;
	private String senhaConta;
	private double saldo;
	private Cliente cliente;
	
	public Conta() {
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public String getSenhaConta() {
		return senhaConta;
	}
	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
