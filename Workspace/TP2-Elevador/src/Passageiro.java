import java.util.Comparator;

public class Passageiro {
	private int ID;
	private int origem;
	private int destino;
	private int intervalo;
	private boolean subir;
	private boolean available;
	private boolean atendido;
	public int horarioEntrada, horarioSaida, duracao;
	

	public Passageiro(int origem, int destino, int intervalo) {
		setOrigem(origem);
		setDestino(destino);
		setSubir();
		setIntervalo(intervalo);
		this.available=false;
		setAtendido(false);
	}
	public Passageiro(int id, int origem, int destino, int intervalo) {
		setID(id);
		setOrigem(origem);
		setDestino(destino);
		setSubir();
		setIntervalo(intervalo);
		this.available=false;
		setAtendido(false);
	}

	
	public int getOrigem() {
		return origem;
	}
	public void setOrigem(int origem) {
		this.origem = origem;
	}
	
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	
	public int getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean isSubir() {
		return subir;
	}
	public void setSubir() {
		subir = origem<destino;
	}
	
	public boolean isAvailable(long localTime) {
		return getIntervalo()<localTime;
	}
	public void setAvailable(long localTime) {
		this.available = getIntervalo()<localTime;
	}

	public boolean isAtendido() {
		return atendido;
	}
	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}
	
	public Passageiro clone() {
		return new Passageiro(this.ID,this.origem,this.destino,this.intervalo);
		
	}
	public int compare(Passageiro p1) {
		if(p1.getIntervalo()<this.getIntervalo())
			return -1;
		else if(p1.getIntervalo() == this.getIntervalo())
			return 0;
		else
			return 1;
	}
	
}
