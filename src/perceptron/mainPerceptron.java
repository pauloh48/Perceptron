package perceptron;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** Classe principal
 *  Faz uso da classe Perceptron, Pessoa e inicializaPessoa
 * 
 * @author pauloh48
 *
 */
public class mainPerceptron {

	public static void main(String[] args) {
		
		inicializaPessoas initPessoas = new inicializaPessoas();// para escolher preenchimento
		Perceptron percep = new Perceptron(); 					// perceptron
		Pessoa [] pessoa; 										
		
		pessoa = new Pessoa[4];									// Cria pessoas e passa parametros
		pessoa[0] = new Pessoa("Bach", 0, 0, 0);
		pessoa[1] = new Pessoa("Beethoven", 0, 1, 0);
		pessoa[2] = new Pessoa("Einstein", 1, 0, 1);
		pessoa[3] = new Pessoa("Kepler", 1, 1, 1);
		
		int i = 0;
		int j;
		int flagBach=0, flagBeethoven=0, flagEinstein=0, flagKepler=0;
		int contEpochs = 1;
		 
		// imprime para verificar se preencheu corretamente
		initPessoas.imprimePessoas(pessoa);
		
		// seleciona forma de escolha manual ou automatica. Manual slide == 3 1 2 0, 3 0 2 1
		initPessoas.menu();
				
		//Executando percptron nas pessoas
		while(true) {
			j = initPessoas.getVetorOrdemPessoa()[i]; 	//acessa ordem do vetor
			
			percep.geraSomatorio(pessoa[j].getN1(), pessoa[j].getN2());
			
			System.out.println(pessoa[j].getNome() +": \n\tSomatorio: " 
								+ percep.getSomatorioSaida() 
								+ ", Saida: " + pessoa[j].getSaida());
			
			//se somatorio é diferente da saida faz correções
			if(percep.getSomatorioSaida() != pessoa[j].getSaida()) {
				percep.funcaoAtivacao();
				percep.atualizaValorErro(pessoa[j].getSaida());
				percep.retropropagacao(pessoa[j].getN1(), pessoa[j].getN2());
				
				System.out.println("\tWB: " + percep.getWb() + ", W1: " 
									+ percep.getW1() + ", W2:" + percep.getW2());
			}
			System.out.println("-------------------------------");
			
			i++;		// conta epocas
			if(i == 4) {
				i = 0;
				contEpochs++;
			}
			//verifica erro de todos tem somatorio igual a 4
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
		
			if((flagBach+flagBeethoven+flagEinstein+flagKepler) == 4)
				break;
			
			//corrigi loop, pois não atualiza valor do erro quando encontra o numero, assim entra em loop
			percep.setValorErro(0); 
		}
		System.out.println("Total de Epocas executadas: " + contEpochs);	
	}
}