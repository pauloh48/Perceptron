package perceptron;

public class Perceptron {
	private int wb = 0, w1=0, w2=0;
	private int bias = 1; // wb == bias. inicializa bia com 1, sinal positivo
	private int valorErro = 0; //SinalEsperado – SinalGerado
	private int sinalGerado;
	private int taxaAprendizagem = 1;
	private int somatorioSaida;
	
	public void geraSomatorio(int N1, int N2) {
		setSomatorioSaida((bias*wb) + (N1*w1) + (N2*w2));	
	}
	
	//funcção de ativação apenas retorna o sinal gerado para corrigir o erro
	public void funcaoAtivacao() {
		if(somatorioSaida > 0)
			setSinalGerado(1);
		else
			setSinalGerado(0);
	}
	
	//atualiza erro
	public void atualizaValorErro(int SinalEsperado) {
		setValorErro(SinalEsperado- getSinalGerado());
		
	}
	
	//retropropaga erro corrigindo pesos
	public void retropropagacao(int N1, int N2) {
		wb = wb + (valorErro * taxaAprendizagem * bias);
		w1 = w1 + (valorErro * taxaAprendizagem * N1);
		w2 = w2 + (valorErro * taxaAprendizagem * N2);
		//setValorErro(0); //corrigir erro de loop
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
