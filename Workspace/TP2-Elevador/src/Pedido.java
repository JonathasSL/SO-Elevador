
public class Pedido {
	private int origem;
	private int destino;
	private int intervalo;
	
	public Pedido(int origem, int destino, int intervalo) {
		setOrigem(origem);
		setDestino(destino);
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
	
}
