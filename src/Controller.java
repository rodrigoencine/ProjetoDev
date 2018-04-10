import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Controller {
	int quantIntervalos = 11;
	Set<Intervalo> listIntervalos = new LinkedHashSet<Intervalo>();
	List<Intervalo> intervalos = new ArrayList<>();
	List<Intervalo> copia = new ArrayList<>();
	List<Intervalo> subConjunto = new ArrayList<>();
	public void criarArquivo(){
		File arquivo = new File("conjunto_6.txt");
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
	private void criarIntervalos(BufferedWriter escrever) throws IOException{
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
			Intervalo intervalo = new Intervalo();
			intervalo.setInicio(Integer.parseInt(tokens[0]));
			intervalo.setFim(Integer.parseInt(tokens[1]));
			int tamanho = intervalo.getFim() - intervalo.getInicio();
			intervalo.setTamanho(tamanho);
			listIntervalos.add(intervalo);
			i++;
		}
	}	
	public void print(){
		System.out.print(listIntervalos.toString());
	}
	public void completaLista() {
		for(Intervalo inter : listIntervalos) {
			intervalos.add(inter);
		}
	}
	public void printLista() {
		for(int i = 0; i<intervalos.size();i++) {
			System.out.println(i + "valores " + intervalos.get(i).getInicio() + " - " + intervalos.get(i).getFim() );
		}
		//System.out.println(intervalos.toString());
	}
	public void ordernar() {
		intervalos.sort(Comparator.comparingInt(u -> u.getFim()));
	}
	public void ordernarComeco() {
		intervalos.sort(Comparator.comparingInt(u -> u.getInicio()));
	}
	public void ordenarTamanho() {
		intervalos.sort(Comparator.comparingInt(u -> u.getTamanho()));
	}
	public int AlgoritmoGuloso(){
		int quant = 0;
		int ultSelecionado = 0;
		quant++;
		subConjunto.add(intervalos.get(0));
		for(int i = 1;i<=intervalos.size()-1;i++){
			if(intervalos.get(i).getInicio()>=intervalos.get(ultSelecionado).getFim()){
				quant ++;
				ultSelecionado = i;
				subConjunto.add(intervalos.get(ultSelecionado));
			}
		}

		return quant;
	}
	public void imprimirSub(){
		System.out.println(subConjunto.toString());
	}
	public void remover() {
		subConjunto.clear();
	}
	public void copiar() {
		for(int i = 0; i<intervalos.size();i++) {
			copia.add(intervalos.get(i));
		}
	}
	public void guloso() {
		remover();
		Integer [] conflitos = new Integer[15];
		boolean achou;
		for(Intervalo inter: intervalos) {
			achou = true;
			for (int i = (inter.getInicio()); i <= (inter.getFim()); i++) {
				if(conflitos[i]!=null) {
					achou = false;
					break;
				}
			}
			if(achou) {
				for (int i = (inter.getInicio()); i<= (inter.getFim()); i++) {
					conflitos[i] = 1;
				}
				subConjunto.add(inter);
			}
		}
	}
	public void contaConflitos() {
		int quant = 0;
		int ultSelecionado = 0;
		//quant++;
		subConjunto.add(intervalos.get(0));
		for(int i = 1;i<=intervalos.size()-1;i++){
			if(intervalos.get(i).getInicio()>=intervalos.get(ultSelecionado).getFim()){
				//quant ++;
				ultSelecionado = i;
				intervalos.get(ultSelecionado).setConflitos(quant);
			}
			else {
			quant++;
			}
		}
	}
	public void quantConflitos() {
		for (int i = 0; i <intervalos.size(); i++) {
			System.out.println("quantidade de conflitos" + intervalos.get(i).getConflitos());
		}
	}
}
