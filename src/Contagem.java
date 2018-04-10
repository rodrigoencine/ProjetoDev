import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//No caso de menor ele nao pega o anterior 
public class Contagem {
	int quantIntervalos = 1000000;
	int [] inicio = new int [quantIntervalos];
	int [] fim = new int [quantIntervalos];
	//int [] inicio = {2,3,1,8,8};
	//int [] fim = {11,6,2,10,9};
	//1,3,4,5,7,8
	
	List<Integer> listaFim= new ArrayList<Integer>();
	List<Integer> listaInicio= new ArrayList<Integer>();
	List<Integer> indices = new ArrayList<Integer>();
	
	//int [] inicio = {1,3,0,5,3,5,6,8,8,2,12};
	//int [] fim =    {4,8,6,7,8,7,10,11,11,13,14};
	
	int [] tamanhoIntervalo = new int [fim.length];
	int [] indice = new int [quantIntervalos];
	
	boolean [] achou = new boolean [quantIntervalos];
	
	public void criarArquivo(){
		File arquivo = new File("conjunto_5.txt");
		try{
			arquivo.createNewFile();
			FileWriter fileWriter = new FileWriter(arquivo);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			criarIntervalos(escrever);
			escrever.close();
			fileWriter.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void criarIntervalos(BufferedWriter escrever) throws IOException{
		Random gerador = new Random();
		int n = 0;
		while(n<this.quantIntervalos){
			int c = gerador.nextInt(1000);
			int f = gerador.nextInt(1000);
			if(c!=f){
				if(c>f){
					escrever.write(f + " " + c);
				}else{
					escrever.write(c + " " + f);
				}
				n++;
				escrever.newLine();
			}
		}
	}
	public void leitura (String arquivo) throws FileNotFoundException{
		Scanner entrada = new Scanner (new FileReader(arquivo));
		int i = 0;
		while(entrada.hasNextLine()){
			String n = entrada.nextLine();
			String [] tokens = n.split(" ");
			inicio[i] = Integer.parseInt(tokens[0]);
			fim[i] = Integer.parseInt(tokens[1]);
			i++;
		}
	}
	public int AlgoritmoGuloso(){
		int quant = 0;
		int ultSelecionado = 0;
		quant++;
		System.out.println(inicio[0] +  "----" + fim[0]);
		for(int i = 1;i<=quantIntervalos-1;i++){
			if(inicio[i]>=fim[ultSelecionado]){
				quant ++;
				ultSelecionado = i;
				System.out.println(inicio[i] +  "----" + fim[i]);
			}
		}

		return quant;
	}
		
	public void OrdenarTerminaPrimeiro() {
		int j,key,i,inic;
		for (j = 1; j < fim.length; j++){
			key = fim[j];
			inic = inicio[j];
			for (i = j - 1; (i >= 0) && (fim[i] > key); i--){
				fim[i + 1] = fim[i];
				inicio[i + 1] = inicio[i];
			}
			fim[i + 1] = key;
			inicio[i + 1] = inic;
		}
	}
	public void OrdenarComecaPrimeiro() {
		int j,key,i,inic;
		for (j = 1; j < inicio.length; j++){
			key = fim[j];
			inic = inicio[j];
			for (i = j - 1; (i >= 0) && (inicio[i] > inic); i--){
				fim[i + 1] = fim[i];
				inicio[i + 1] = inicio[i];
			}
			fim[i + 1] = key;
			inicio[i + 1] = inic;
		}
	}
	public void ordenarMenorIntervalo(){
		int j,key,i,inic,menor;
		for (j = 1; j < fim.length; j++){
			key = fim[j];
			inic = inicio[j];
			menor = tamanhoIntervalo[j];
			for (i = j - 1; (i >= 0) && (tamanhoIntervalo[i] > menor); i--){
				tamanhoIntervalo[ i + 1] = tamanhoIntervalo [i];
				fim[i + 1] = fim[i];
				inicio[i + 1] = inicio[i];
			}
			tamanhoIntervalo[ i +1] = menor;
			fim[i + 1] = key;
			inicio[i + 1] = inic;
		}
	}
	//tenho que executar esse comando na classe teste
	public void gerarTamanhoIntervalo(){
		for(int i = 0; i<this.quantIntervalos;i++){
			tamanhoIntervalo[i] = fim[i] - inicio[i];
		}
	}
	public void print(){
		for(int i = 0; i<quantIntervalos;i++){
			System.out.println(i + "Inicio: " + this.inicio[i] + "Fim: " + this.fim[i]);
		}
	}
	public void imprimirTamanhoIntervalo(){
		for(int i = 0; i<this.quantIntervalos;i++){
			System.out.println("Tamanho" + this.tamanhoIntervalo[i]);
		}
	}

	public void imprimirVetor(){
		for(int i = 0; i<this.quantIntervalos;i++){
			System.out.println(achou[i]);
		}
	}
	public void imprimirIndices() {
		for(int i = 0; i<this.indices.size();i++){
			System.out.println(indices.get(i));
		}
	}
	public void repetidos() {
		for(int i = 0; i<quantIntervalos;i++){
			int j = inicio[i];
			int k = fim[i];
			int cont = 0;
			for(int n = i;n<quantIntervalos - 1;n++) {
				if(j==inicio[n+1] && k==fim[n+1]&& !achou[n+1]) {
					indices.add(n+1);
					achou[n+1] = true;
					cont++;
				}
			}
			if(cont>0) {
			achou[i] = true;
			indices.add(i);
			}
		}
	}

	public void remover() {
		for(int i = 0; i<indices.size();i++) {
			inicio[indices.get(i)] = -1;
		}
	}
	public void criar(){
		for(int i = 0; i<inicio.length;i++) {
			if(inicio[i]!=-1) {
				listaInicio.add(inicio[i]);
				listaFim.add(fim[i]);
				
			}
		}
	}
	public void imprimiLista() {
		for(int i = 0; i<listaInicio.size();i++) {
			System.out.println("valores" + i + "inicio " + listaInicio.get(i) + " fim" + listaFim.get(i));
		}
	}
	public void imprimiInicio() {
		for(int i = 0; i<inicio.length;i++) {
			System.out.println("valores" + i + ": " + inicio[i]);
		}
	}
}
