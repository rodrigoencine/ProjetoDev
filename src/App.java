import java.io.FileNotFoundException;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Controller cont = new Controller();
		//cont.criarArquivo();
		String arquivo = "conjunto_6.txt";
		cont.leitura(arquivo);
		cont.print();
		System.out.println("----------");
		cont.completaLista();
		cont.printLista();
		//cont.limpar();
		System.out.println("---------------");
		//cont.copiar();
		//cont.ordenarTamanho();
		//cont.printLista();
		cont.ordernar();
		cont.printLista();
		//System.out.println(cont.AlgoritmoGuloso());
		//cont.imprimirSub();
		//System.out.println("-----ordenado pelo inicio----------");
		//cont.ordernarComeco();
		//cont.printLista();
		//cont.remover();
		//System.out.println(cont.AlgoritmoGuloso());
		//cont.imprimirSub();
		//cont.guloso();
		//cont.imprimirSub();
		cont.ordernarComeco();
		cont.contaConflitos();
		cont.quantConflitos();
	}

}
