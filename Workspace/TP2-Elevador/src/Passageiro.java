import java.util.Comparator;

public class Passageiro {
	private int ID;
	private int origem;
	private int destino;
	private int intervalo;
	private boolean subir;
	
	public Passageiro(int origem, int destino, int intervalo) {
		setOrigem(origem);
		setDestino(destino);
		setSubir();
		setIntervalo(intervalo);
	}
	public Passageiro(int id, int origem, int destino, int intervalo) {
		setOrigem(origem);
		setDestino(destino);
		setSubir();
		setIntervalo(intervalo);
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
		if(this.origem<this.destino)
			subir = true;
		else
			subir = false;
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
