import java.io.FileNotFoundException;
import java.util.Scanner;



public class Aplicacao {

	public static void main(String[] args) throws FileNotFoundException {
		Controller cont = new Controller();
		Scanner entrada = new Scanner(System.in);
		System.out.println("--------Menu---------");
		System.out.println("Favor informe nome do arquivo de teste");
		for(int i = 0; i<10;i++) {
			System.out.println("teste" + (i+1) + ".txt");
		}
		String arquivo = entrada.nextLine();
		cont.leitura(arquivo);
		cont.print();
	}
}
