package perceptron;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class inicializaPessoas {
	private Integer[] vetorOrdemPessoa = new Integer[4];
	//sortear 4 numeros de 0 a 3, armazenar num vetor e percorren na ordem do vetor
	
	public void menu() {
		Scanner ler = new Scanner(System.in);
		
		int escolha;
		do {
			System.out.println("Escolha a forma como as pessoas sao selecionadas");
			System.out.println("0. Forma manual");
			System.out.println("1. Forma automatica");
			escolha = ler.nextInt();
		}while(escolha!=0 && escolha!=1);
		
		if(escolha == 0)
			inicilizaManual();
		else
			inicializaRandom();
	}
	
	public void inicilizaManual() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o valor referente a ordem de aprendizado: 'ex.: 0 1 2 3' ");
		System.out.println("0. Bach\n" + "1. Beethoven\n" + "2. Einstein\n"+ "4.Kepler");
		vetorOrdemPessoa[0] = ler.nextInt();
		vetorOrdemPessoa[1] = ler.nextInt();
		vetorOrdemPessoa[2] = ler.nextInt();
		vetorOrdemPessoa[3] = ler.nextInt();
	}
	
	public void inicializaRandom() {
		Random gerador = new Random();
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

	public Integer[] getVetorOrdemPessoa() {
		return vetorOrdemPessoa;
	}

	public void setVetorOrdemPessoa(Integer[] vetorOrdemPessoa) {
		this.vetorOrdemPessoa = vetorOrdemPessoa;
	}
	
	
}
