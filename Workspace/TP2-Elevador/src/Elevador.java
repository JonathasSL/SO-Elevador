import java.util.ArrayList;

public class Elevador implements Runnable{
	private Estado estado;
	private ArrayList<Passageiro> passageiros;
	private int andar;
	private Thread thread;

	public Elevador(String nome,Passageiro passageiro) {
		setEstado(Estado.parado);
		passageiros.add(passageiro);
		new Thread(this,nome).start();
		
	}

	@Override
	public void run() {
		while(!passageiros.isEmpty()){
			passageiros.add(Main.getFirst());
		}
	}

	public void goToFloor(int here, int goTo) {
		try {
			for(int i=here; i <= goTo ;i++) {
				
				thread.sleep(30);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
