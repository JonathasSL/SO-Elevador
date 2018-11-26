import java.util.ArrayList;

public class Elevador extends Thread implements Runnable{
	private Estado estado;
	private ArrayList<Passageiro> passageiros;
	private int andar;
	public Distribuidora distribuidora;

	public Elevador(String nome, Distribuidora d) {
		this.distribuidora = d;
		setAndar(-1);
		setEstado(Estado.parado);
		passageiros = new ArrayList<>();
		new Thread(this,nome).start();
	}

	@Override
	public void run() {
			do{
				Passageiro p = distribuidora.getNext();
//				System.out.println(Thread.currentThread().getName()+" "+passageiros.size()+" \tfinished: "+Main.finished());
				if(p!=null)
					passageiros.add(p);
				else
					Thread.currentThread().interrupt();
			}while(!distribuidora.finished());
			System.out.println(Thread.currentThread().getName()+" "+passageiros.size());
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
