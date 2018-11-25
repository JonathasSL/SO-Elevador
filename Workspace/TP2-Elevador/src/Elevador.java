import java.util.ArrayList;

public class Elevador implements Runnable{
	private Estado estado;
	
	private ArrayList<Pedido> passageiros;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public synchronized void novoPassageiro(Pedido passageiro) {
		passageiros.add(passageiro);
	}

	public ArrayList<Pedido> getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(ArrayList<Pedido> passageiros) {
		this.passageiros = passageiros;
	}
	
}
