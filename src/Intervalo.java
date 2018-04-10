
public class Intervalo {
	private int inicio;
	private int fim;
	private int tamanho;
	private boolean contem;
	private int conflitos;
	
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getFim() {
		return fim;
	}
	public void setFim(int fim) {
		this.fim = fim;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isContem() {
		return contem;
	}
	public void setContem(boolean contem) {
		this.contem = contem;
	}
	
	public String toString(){
		String msg = " ";
		msg = msg + "Inicio" + this.inicio + "Fim" + this.fim;
		return msg;
	}
	
	public int getConflitos() {
		return conflitos;
	}
	public void setConflitos(int conflitos) {
		this.conflitos = conflitos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fim;
		result = prime * result + inicio;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intervalo other = (Intervalo) obj;
		if (fim != other.fim)
			return false;
		if (inicio != other.inicio)
			return false;
		return true;
	}
	
}
