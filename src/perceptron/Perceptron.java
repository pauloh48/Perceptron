package perceptron;

/** Classe perceprtron
 * 
 * @author pauloh48
 *
 */
public class Perceptron {
	private int wb = 0, w1=0, w2=0;
	private int bias = 1; // wb == bias. inicializa bia com 1, sinal positivo
	private int valorErro = 0; //SinalEsperado – SinalGerado
	private int sinalGerado;
	private int taxaAprendizagem = 1;
	private int somatorioSaida;
	
	/** Funçao para calcular o somatorio dos parametros com seus pesos e bias
	 * 
	 * @param N1 - int: entrada 1 do individuo
	 * @param N2 - int: entrada 2 do individuo
	 */
	public void geraSomatorio(int N1, int N2) {
		setSomatorioSaida((bias*wb) + (N1*w1) + (N2*w2));	
	}
	
	/** Função de ativação altera o valor do sinalGerado para corrigir o erro
	 * 
	 * 
	 */
	public void funcaoAtivacao() {
		if(somatorioSaida > 0)
			setSinalGerado(1);
		else
			setSinalGerado(0);
	}
	
	/** Função para calcular o Erro do individuo
	 * 
	 * @param SinalEsperado: representa a saida do individuo
	 */
	public void atualizaValorErro(int SinalEsperado) {
		setValorErro(SinalEsperado- getSinalGerado());
		
	}
	
	/** Função para retropragar a atualização dos pesos 
	 * 
	 * @param N1 - int: entrada 1 do individuo
	 * @param N2 - int: entrada 2 do individuo
	 */
	public void retropropagacao(int N1, int N2) {
		wb = wb + (valorErro * taxaAprendizagem * bias);
		w1 = w1 + (valorErro * taxaAprendizagem * N1);
		w2 = w2 + (valorErro * taxaAprendizagem * N2);
	}
	
	public int getSomatorioSaida() {
		return somatorioSaida;
	}
	public void setSomatorioSaida(int somatorioSaida) {
		this.somatorioSaida = somatorioSaida;
	}

	public int getSinalGerado() {
		return sinalGerado;
	}

	public void setSinalGerado(int sinalGerado) {
		this.sinalGerado = sinalGerado;
	}

	public int getWb() {
		return wb;
	}

	public void setWb(int wb) {
		this.wb = wb;
	}

	public int getW1() {
		return w1;
	}

	public void setW1(int w1) {
		this.w1 = w1;
	}

	public int getW2() {
		return w2;
	}

	public void setW2(int w2) {
		this.w2 = w2;
	}

	public int getValorErro() {
		return valorErro;
	}

	public void setValorErro(int valorErro) {
		this.valorErro = valorErro;
	}
}
