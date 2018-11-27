import java.util.ArrayList;

public class Elevador extends Thread implements Runnable{
	private Estado estado;
	private ArrayList<Passageiro> passageiros;
	private int andar;
	public Distribuidora distribuidora;
	private static final long MOVIMENTO_ELEVADOR = 10;

	public Elevador(String nome, Distribuidora d) {
		this.distribuidora = d;
		setAndar(-1);
		setEstado(Estado.parado);
		passageiros = new ArrayList<>();
		new Thread(this,nome).start();
	}

	@Override
	public void run() {
		Passageiro p;
		while(!distribuidora.finished()){
			try {
				p = distribuidora.getNext();
				Thread.sleep(p.getIntervalo());
				System.out.println(p.getID());
				
				if(p.getOrigem()>andar) {
					estado = Estado.subindo;
					Thread.sleep((p.getOrigem()-andar)*MOVIMENTO_ELEVADOR);
					andar = p.getOrigem();
				}else if(andar>p.getOrigem()) {
					estado = Estado.descendo;
					Thread.sleep((andar-p.getOrigem())*MOVIMENTO_ELEVADOR);
					p.getOrigem();
				}
				
				if(p.getDestino()>andar) {
					estado = Estado.subindo;
					Thread.sleep((p.getDestino()-andar)*MOVIMENTO_ELEVADOR);
					andar = p.getDestino();
				}else if(andar>p.getDestino()) {
					estado = Estado.descendo;
					Thread.sleep((andar-p.getDestino())*MOVIMENTO_ELEVADOR);
					p.getDestino();
				}
				
				estado = Estado.parado;


				if(p!=null)
					passageiros.add(p);
				else
					Thread.currentThread().interrupt();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
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
