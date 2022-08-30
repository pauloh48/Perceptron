package perceptron;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/** Classe inicializaPessoas
 *  Fornece interface para selecionar a ordem das pessoas
 * 
 * @author pauloh48
 *
 */
public class inicializaPessoas {
	private Integer[] vetorOrdemPessoa = new Integer[4];
	
	/** Imprime tabela cientista compositor
	 * 
	 * @param pessoa - Pessoa: vetor de pessoas criado
	 */
	public void imprimePessoas(Pessoa[] pessoa) {
		System.out.println("Personalidade  |  tN1  |  tN2  |  SAIDA");
		System.out.println(pessoa[0].getNome() + "\t       |   " + pessoa[0].getN1() + "   |   " 
				+ pessoa[0].getN2() + "   |   " + pessoa[0].getSaida());
		System.out.println(pessoa[1].getNome() + "      |   " +pessoa[1].getN1() + "   |   " 
				+ pessoa[1].getN2() + "   |   " + pessoa[1].getSaida());
		System.out.println(pessoa[2].getNome() + "       |   " +pessoa[2].getN1() + "   |   " 
				+ pessoa[2].getN2() + "   |   " + pessoa[2].getSaida());
		System.out.println(pessoa[3].getNome() + "         |   " +pessoa[3].getN1() + "   |   " 
				+ pessoa[3].getN2() + "   |   " + pessoa[3].getSaida() + "\n");
	}
	
	/** Seleciona a ordem das pessoas é manual ou automatico/randomica
	 * 
	 */
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
	
	/** Função para inicializar de forma manual
	 * 
	 */
	public void inicilizaManual() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o valor referente a ordem de aprendizado: 'ex.: 0 1 2 3' ");
		System.out.println("0. Bach\n" + "1. Beethoven\n" + "2. Einstein\n"+ "4.Kepler");
		vetorOrdemPessoa[0] = ler.nextInt();
		vetorOrdemPessoa[1] = ler.nextInt();
		vetorOrdemPessoa[2] = ler.nextInt();
		vetorOrdemPessoa[3] = ler.nextInt();
	}
	
	 /** Função para inicializar de forma automatico/randomica
	  * 
	  *  Verifica se numero sorteado está na lista, se não tiver 
	  *  adicina esse numero no vetorOrdemPessoa e insere este
	  *  na lista. Caso esteja na lista continua sorteando.
	  *  O programa para quando preencher as 4 posições.
	  *  
	  */
	public void inicializaRandom() {
		Random gerador = new Random();
		int i = 0;
		int numAux;
		while(true) {
			// atualiza lista com valores inseridos no vetorOrdemPessoa
        	List<Integer> lista = Arrays.asList(vetorOrdemPessoa);
        	
        	numAux = gerador.nextInt(4); // sorteio de 0 a 3
        	if(!lista.contains(numAux)) { //se não contem na lista/vetor, adiciona numAux e incrementa i
        		vetorOrdemPessoa[i] = numAux; 
        		i++;
        	}
        	
        	if(i == 4)	// parada
        		break;
         }
	}

	public Integer[] getVetorOrdemPessoa() {
		return vetorOrdemPessoa;
	}

	public void setVetorOrdemPessoa(Integer[] vetorOrdemPessoa) {
		this.vetorOrdemPessoa = vetorOrdemPessoa;
	}
}
