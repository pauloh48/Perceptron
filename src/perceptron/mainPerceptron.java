package perceptron;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class mainPerceptron {

	public static void main(String[] args) {
		
		inicializaPessoas initPessoas = new inicializaPessoas(); // para escolher preenchimento
		
		Perceptron percep = new Perceptron(); // perceptron
		
		Pessoa [] pessoa; 			// Cria pessoas e passa parametros
		pessoa = new Pessoa[4];
		
		pessoa[0] = new Pessoa("Bach", 0, 0, 0);
		pessoa[1] = new Pessoa("Beethoven", 0, 1, 0);
		pessoa[2] = new Pessoa("Einstein", 1, 0, 1);
		pessoa[3] = new Pessoa("Kepler", 1, 1, 1);
		
		 
		
		int i = 0;
		int j;
		int flagBach=0, flagBeethoven=0, flagEinstein=0, flagKepler=0;
		int contEpochs = 1;
		 
		// imprime para verificar se preencheu corretamente
		System.out.println("Personalidade  |  tN1  |  tN2  |  SAIDA");
		System.out.println(pessoa[0].getNome() + "\t       |   " + pessoa[0].getN1() + "   |   " 
				+ pessoa[0].getN2() + "   |   " + pessoa[0].getSaida());
		System.out.println(pessoa[1].getNome() + "      |   " +pessoa[1].getN1() + "   |   " 
				+ pessoa[1].getN2() + "   |   " + pessoa[1].getSaida());
		System.out.println(pessoa[2].getNome() + "       |   " +pessoa[2].getN1() + "   |   " 
				+ pessoa[2].getN2() + "   |   " + pessoa[2].getSaida());
		System.out.println(pessoa[3].getNome() + "         |   " +pessoa[3].getN1() + "   |   " 
				+ pessoa[3].getN2() + "   |   " + pessoa[3].getSaida());
		
		// seleciona forma de escolha manual ou automatica. Manual slide == 3 1 2 0, 3 0 2 1
		initPessoas.menu();
				
		//int aux = 0;
		//testando pessoas
		while(true) {
			//j = vetorOrdemPessoa[i];
			j = initPessoas.getVetorOrdemPessoa()[i];//acessa vetor
			
			percep.geraSomatorio(pessoa[j].getN1(), pessoa[j].getN2());
			System.out.println(pessoa[j].getNome() +": \n\tSomatorio: " + percep.getSomatorioSaida() 
				+ ", Saida: " + pessoa[j].getSaida());
			
			if(percep.getSomatorioSaida() != pessoa[j].getSaida()) {
				percep.funcaoAtivacao();
				percep.atualizaValorErro(pessoa[j].getSaida());
				percep.retropropagacao(pessoa[j].getN1(), pessoa[j].getN2());
				
				System.out.println("\tWB: " + percep.getWb() + ", W1: "+ percep.getW1() + ", W2:"+ percep.getW2());
			}
			System.out.println("-------------------------------");
			
			i++;
			if(i == 4) {
				i = 0;
				contEpochs++;
			}
			//verifica erro
			if(percep.getValorErro() == 0 && pessoa[j].getNome().equals("Bach"))
				flagBach = 1;
			else if(percep.getValorErro() != 0 && pessoa[j].getNome().equals("Bach"))
				flagBach = 0;
			
			else if(percep.getValorErro() == 0 && pessoa[j].getNome().equals("Beethoven"))
				flagBeethoven = 1;
			else if(percep.getValorErro() != 0 && pessoa[j].getNome().equals("Beethoven"))
				flagBeethoven = 0;
			
			else if(percep.getValorErro() == 0 && pessoa[j].getNome().equals("Einstein"))
				flagEinstein = 1;
			else if(percep.getValorErro() != 0 && pessoa[j].getNome().equals("Einstein"))
				flagEinstein = 0;
			
			else if(percep.getValorErro() == 0 && pessoa[j].getNome().equals("Kepler"))
				flagKepler = 1;
			else if(percep.getValorErro() != 0 && pessoa[j].getNome().equals("Kepler"))
				flagKepler = 0;
		
			if((flagBach+flagBeethoven+flagEinstein+flagKepler) == 4 /*|| contEpochs > 1000*/)
				break;
			percep.setValorErro(0); //corrigir loop pois não atualiza valor do erro quando encontra o numero
			/*aux++;
			if(aux == 500)
				System.out.println("AAAAAAAAAAAAAAAAA");*/
		}
		System.out.println("Total de Epocas executadas: " + contEpochs);
		/*
		percep.geraSomatorio(pessoa[3].getN1(), pessoa[0].getN2());
		System.out.println(pessoa[3].getNome() +"\n" + percep.getSomatorioSaida());
		
		if(percep.getSomatorioSaida() != pessoa[3].getSaida()) {
			percep.funcaoAtivacao();
			percep.atualizaValorErro(pessoa[3].getSaida());
			percep.retropropagacao(pessoa[3].getN1(), pessoa[3].getN2());
			
			System.out.println(percep.getWb() + ", "+ percep.getW1() + ", "+ percep.getW2());
		}
		
		percep.geraSomatorio(pessoa[1].getN1(), pessoa[1].getN2());
		//testando com betoven
		System.out.println(pessoa[1].getNome() +"\n" + percep.getSomatorioSaida());
		
		if(percep.getSomatorioSaida() != pessoa[1].getSaida()) {
			percep.funcaoAtivacao();
			percep.atualizaValorErro(pessoa[1].getSaida());
			percep.retropropagacao(pessoa[1].getN1(), pessoa[1].getN2());
			
			System.out.println(percep.getWb() + ", "+ percep.getW1() + ", "+ percep.getW2());
		}
		
		// teste einstein
		percep.geraSomatorio(pessoa[2].getN1(), pessoa[2].getN2());
		System.out.println(pessoa[2].getNome() +"\n" + percep.getSomatorioSaida());
		
		if(percep.getSomatorioSaida() != pessoa[2].getSaida()) {
			percep.funcaoAtivacao();
			percep.atualizaValorErro(pessoa[2].getSaida());
			percep.retropropagacao(pessoa[2].getN1(), pessoa[2].getN2());
			
			System.out.println(percep.getWb() + ", "+ percep.getW1() + ", "+ percep.getW2());
		}
		
		
		// teste bach
		percep.geraSomatorio(pessoa[0].getN1(), pessoa[0].getN2());
		System.out.println(pessoa[0].getNome() +"\n" + percep.getSomatorioSaida());
		
		if(percep.getSomatorioSaida() != pessoa[0].getSaida()) {
			percep.funcaoAtivacao();
			percep.atualizaValorErro(pessoa[0].getSaida());
			percep.retropropagacao(pessoa[0].getN1(), pessoa[0].getN2());
			
			System.out.println(percep.getWb() + ", "+ percep.getW1() + ", "+ percep.getW2());
		}
		*/		
	}

	private static void inicializaRandom(Random gerador, Integer[] vetorOrdemPessoa) {
		int i = 0;
		int numAux;
		while(true) {
			//i = 0;
        	List<Integer> lista = Arrays.asList(vetorOrdemPessoa);
        	
        	numAux = gerador.nextInt(4); // sorteio de 0 a 3
        	if(!lista.contains(numAux)) { //se não contem na lista/vetor, adiciona numAux e incrementa i
        		vetorOrdemPessoa[i] = numAux; 
        		i++;
        	}
        	
        	if(i == 4)	// parada
        		break;
        	//System.out.println(gerador.nextInt(4));
         }
	}

}

/*
 * //perceptron
		//inicializa pesos com 0
		int wb = 0, w1=0, w2=0;
		int bias = 1; // wb == bias. inicializa bia com 1, sinal positivo
		int valorErro = 0; //SinalEsperado – SinalGerado
		int sinalGerado;
		int taxaAprendizagem = 1;
		int sinalEntrada = 1;
		
		//somatorio = (Bias*Wb)+(N1*W1)+(N2*W2) == sinal gerado
		
		
		
Kepler
0
0, 0, 0
1, 1, 1
Beethoven
2
1, 1, 1
0, 1, 0
Einstein
1
0, 1, 0
Bach
0
0, 1, 0
 * 
 * */
