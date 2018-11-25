import java.util.ArrayList;

public class Elevador implements Runnable{
	private Estado estado;
	private ArrayList<Passageiro> passageiros;
	private int andar;
	
	public Elevador() {
		estado = Estado.parado;
	}
	
	@Override
	public void run() {
		while(!passageiros.isEmpty()) {
			
		}
	}
	public synchronized void nextPedido(Passageiro passageiro) {
		passageiros.add(passageiro);
	}

	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(ArrayList<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	
	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}
	
}
