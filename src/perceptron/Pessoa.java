package perceptron;

/** Classe pessoa
 * 
 * @author pauloh48
 *
 */
public class Pessoa {
	private String nome;
	private int N1;
	private int N2;
	private int saida;
	
	public Pessoa(String nome, int N1, int N2, int saida){
		this.nome = nome;
		this.N1 = N1;
		this.N2 = N2;
		this.saida = saida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getN1() {
		return N1;
	}

	public void setN1(int n1) {
		N1 = n1;
	}

	public int getN2() {
		return N2;
	}

	public void setN2(int n2) {
		N2 = n2;
	}

	public int getSaida() {
		return saida;
	}

	public void setSaida(int saida) {
		this.saida = saida;
	}
}
