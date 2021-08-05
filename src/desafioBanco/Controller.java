package desafioBanco;


import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;



public class Controller {

	private static Cliente cliente;
	private static Conta conta;
	private static Funcionario funcionario;
	private static List<Cliente> listaCliente = new ArrayList<>();
	private static List<Funcionario> listaFuncionario = new ArrayList();
	

	public static void main(String[] args) {

		 menu();
		
	}
	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		boolean sair = true;
		
		do {
			System.out.println("=======================================================");
			System.out.println("                          Menu                         ");
			System.out.println("=======================================================");
			System.out.println("[1] Cadastro Cliente");
			System.out.println("[2] Cadastro Funcionário");
			System.out.println("[3] Depositar");
			System.out.println("[4] Transferir");
			System.out.println("[5] imprimir extrato");
			System.out.println("[6] lista conta clientes");
			System.out.println("[0] Sair");
			System.out.print("Operação: ");
			int operacao = sc.nextInt();
			System.out.println("=======================================================");
			switch (operacao) {
			case 1:
				cadastroCliente();
				criarContaCliente();
				break;
			case 2:
				cadastroFuncionario();
				criarContaFuncionario();
				break;
			case 3:
				deposita();
				break;
			case 4:
				transfere();
				break;
			case 5:
				imprimirExtrato();
				break;
			case 6:
				mostrarC();
				break;
			case 0:
				sair = false;
				break;
			default:
				System.out.println("Operação inválida");	
			}
		} while (sair);
		System.out.println("Até logo");
		
	}
		
	public static void cadastroCliente() {
		
		cliente = new Cliente();

		Scanner sc = new Scanner(System.in);
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("=====================Dados Cliente=====================");
		System.out.print("Informe seu Nome Completo: ");
		cliente.setNomeCompleto(sc.nextLine());
		System.out.print("Informe seu Endereço Atual: ");
		cliente.setEndereco(sc.nextLine());

		System.out.print("Informe seu CEP: ");
		cliente.setCep(sc.nextInt());

		System.out.print("Informe seu CPF: ");
		cliente.setCpf(sc.nextInt());

		System.out.print("Informe seu RG: ");
		cliente.setRg(sc.nextInt());

		listaCliente.add(cliente);

	}

	public static void cadastroFuncionario() {
		funcionario = new Funcionario();
		Scanner sc = new Scanner(System.in);
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("=====================Dados Funcionario=================");
		System.out.print("Informe o nome completo: ");
		funcionario.setNomeCompleto(sc.nextLine());

		System.out.print("Informe o cargo: ");
		funcionario.setCargo(sc.nextLine());

		System.out.print("Informe o salario: ");
		funcionario.setSalario(sc.nextDouble());

		System.out.print("Informe o endereço atual: ");
		funcionario.setEndereco(sc.nextLine());

		System.out.print("Informe o CEP: ");
		funcionario.setCep(sc.nextInt());

		System.out.print("Informe o CPF: ");
		funcionario.setCpf(sc.nextInt());

		System.out.print("Informe o RG: ");
		funcionario.setRg(sc.nextInt());

		listaFuncionario.add(funcionario);

	}

	public static void criarContaCliente() {
		conta = new Conta();

		Scanner sc = new Scanner(System.in);
		System.out.println("======================Dados Conta======================");
		System.out.print("Ingresar senha: ");
		conta.setSenhaConta(sc.nextLine());
		System.out.print("Ingresar Numero da agencia: ");
		conta.setNumAgencia(sc.nextInt());
		System.out.print("Ingresar Numero da Conta: ");
		conta.setNumConta(sc.nextInt());

		System.out.print("Ingresar Valor de abertura: ");
		conta.setSaldo(sc.nextDouble());
		cliente.setConta(conta);
		System.out.println("_______________________________________________________");
	}
	
	
	public static void criarContaFuncionario() {
		conta = new Conta();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("======================Dados Conta======================");
		System.out.print("Ingresar senha: ");
		conta.setSenhaConta(sc.nextLine());
		System.out.print("Ingresar Numero da agencia");
		conta.setNumAgencia(sc.nextInt());
		System.out.print("Ingresar Numero da Conta: ");
		conta.setNumConta(sc.nextInt());

		System.out.print("Ingresar Valor de abertura: ");
		conta.setSaldo(sc.nextDouble());
		funcionario.setConta(conta);
	}

	
	public static void saque() {
		double qtd;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nInforme o valor do saque: ");
		qtd = sc.nextDouble();
		
		if(qtd < conta.getSaldo() ) {
			conta.setSaldo(conta.getSaldo() - qtd );
		}
	}
	
	public static void deposita() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("informe o valor depositado: ");
		double qtd = sc.nextDouble();
		Conta deposita = new Conta();
		deposita.setSaldo(qtd + conta.getSaldo());
		
		System.out.print("Ingresar numero da conta: ");
		int numDestino = sc.nextInt();
		
		for(Cliente lista: listaCliente) {
			if(lista.getConta().getNumConta() == numDestino) {
				lista.setConta(deposita);
			}
		}
		
	}
	
	public static void transfereDestino(Conta destino, double valor) {
		destino.setSaldo(destino.getSaldo() + valor);
	}
	
	public static void transfere() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingresar numero da conta para transferencia: ");
		int contaDestino = sc.nextInt();
		
		System.out.print("Valor da transferencia: R$ ");
		double inputValor = sc.nextDouble();
		Conta objValor = new Conta();
		objValor.setSaldo(conta.getSaldo() + inputValor );
		
		System.out.print("Ingresar numero da conta atual: ");
		int contaAtual = sc.nextInt();
		Conta objTranferencia = new Conta();
		objTranferencia.setSaldo(inputValor - conta.getSaldo());
		
			for(Cliente cliente: listaCliente){
				
				if(cliente.getConta().getNumConta() == contaDestino){
					//cliente.setConta(objValor);
					Conta conta = cliente.getConta();
					conta.setSaldo(conta.getSaldo() + inputValor);
					
				}
				if(cliente.getConta().getNumConta() ==  contaAtual) {
					//cliente.setConta(objTranferencia);
					Conta conta = cliente.getConta();
					conta.setSaldo(conta.getSaldo() - inputValor);
					
				}
			}
		
	}
	
	
	
	public static void imprimirExtrato() {
		Scanner sc = new Scanner(System.in);
		System.out.print("[1] Imprimir extrato do Cliente: ");
		System.out.print("[2] Imprimir extrato do Funcionário: ");
		int op = sc.nextInt();
		if(op  == 1) {
			extratoCliente();
		}else if(op == 2) {
			extratoFuncionario();
		}
		
		
	}
	
	public static void extratoCliente() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime data = LocalDateTime.now();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresar o numero da conta: ");
		int input = sc.nextInt();
		for(Cliente lista: listaCliente) {
			if(lista.getConta().getNumConta() == input) {
				System.out.println("=======================================================");
				System.out.println("Extrato da conta: " + lista.getConta().getNumConta());
				System.out.println(dtf.format(data));
				System.out.println();
				System.out.println("Cliente - "+ lista.getNomeCompleto());
				System.out.println();
				System.out.println("Agência - "+ lista.getConta().getNumAgencia());
				System.out.println("Periodo do extrato");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("=======================================================");
			}
			
		}
	}
	
	
	
	public static void extratoFuncionario() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime data = LocalDateTime.now();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresar o numero da conta: ");
		int input = sc.nextInt();
		for(Funcionario lista: listaFuncionario) {
			if(lista.getConta().getNumConta() == input) {
				System.out.println("=======================================================");
				System.out.println("Extrato da conta: " + lista.getConta().getNumConta());
				System.out.println(dtf.format(data));
				System.out.println();
				System.out.println("Cliente - "+ lista.getNomeCompleto());
				System.out.println();
				System.out.println("Agência - "+ lista.getConta().getNumAgencia());
				System.out.println("Periodo do extrato");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("=======================================================");
			}
			
		}
	}
	
	
	public static void mostrarC() {
		
		for(Cliente c: listaCliente) {
			System.out.println("||||||||||||||||||||||||||||");
			System.out.println("============================");
			System.out.println("|Nome     |"+c.getNomeCompleto());
			System.out.println("|Endereco |" + c.getEndereco());
			System.out.println("|CEP:     |" + c.getCep());
			System.out.println("|CPF:     |" + c.getCpf());
			System.out.println("|RG:      |" + c.getRg());
			System.out.println("|Saldo:   |" + c.getConta().getSaldo());
			System.out.println("============================");
			
		}
		
	}

	
	
}
