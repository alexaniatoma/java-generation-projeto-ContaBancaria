package conta.repository;

import conta.model.Conta;

public interface IContaRepository {
	
	//CRUD DA CONTA (CREATE READ UPDATE DELETE)	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	//Metodos Bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);

}
