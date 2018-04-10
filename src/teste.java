import java.io.IOException;

public class teste {
	public static void main (String [] args) throws IOException{
		Contagem cont = new Contagem();
		//cont.criarArquivo();
		String arquivo = "conjunto_5.txt";
		cont.leitura(arquivo);
		//cont.print();
		//System.out.println("------Comeca-------");
		//cont.OrdenarComecaPrimeiro();
		//cont.AlgoritmoGuloso();
		//cont.print();
		//System.out.println("------Menor-------");
		//cont.gerarTamanhoIntervalo();
		//cont.ordenarMenorIntervalo();
		//cont.AlgoritmoGuloso();
		//cont.print();
		//System.out.println("-----Termina--------");
		//cont.OrdenarTerminaPrimeiro();
		//cont.AlgoritmoGuloso();
		//cont.print();
		//cont.imprimirTamanhoIntervalo();
		//cont.imprimirVetor();
		
		
		cont.repetidos();
		//cont.imprimirVetor();
		//cont.imprimirIndices();
		cont.remover();
		cont.criar();
		//cont.imprimiInicio();
		System.out.println("---------------------");
		cont.imprimiLista();
	}	
}

