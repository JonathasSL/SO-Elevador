import java.util.ArrayList;

public class Elevador implements Runnable{
	private Estado estado;
	private ArrayList<Passageiro> passageiros;
	private int andar;

	public Elevador(String nome,Passageiro passageiro) {
		setEstado(Estado.parado);
		passageiros = new ArrayList<>();
		passageiros.add(passageiro);
		new Thread(this,nome).start();
	}

	@Override
	public void run() {
		try{
			while(!passageiros.isEmpty()){
				Thread.sleep(30);
				System.out.println(passageiros.get(0).getID());
				passageiros.add(Main.getFirst());
				System.out.println("size"+passageiros.size());
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void goToFloor(int here, int goTo) {
		try {
			for(int i=here; i <= goTo ;i++) {

				Thread.sleep(30);
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
