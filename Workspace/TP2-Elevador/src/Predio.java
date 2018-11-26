import java.util.ArrayList;

public class Predio {
	private Elevador e1,e2,e3;
	private static ArrayList<Passageiro> demanda;
	private long inicio,horario;

	public Predio(ArrayList<Passageiro> demanda) throws InterruptedException {
		this.demanda = demanda;
		
		inicio = System.currentTimeMillis();
//		Passageiro p = Main.getFirst();
//		Thread.sleep(p.getIntervalo());
		
	}

	public synchronized Passageiro availableOnFloor(int floor, long time) {
		Passageiro temp = null;
		int index = 0;
		boolean available = false;

		for(int i=0; i<demanda.size() && !available ;i++) {
			if(demanda.get(i).getOrigem() == floor) {
				available = demanda.get(i).isAvailable(time);
				if(available) {
					temp = demanda.get(i);
					demanda.get(i).setAtendido(true);
				}
			}
		}
		return temp;
	}


	//	private void setAndares(ArrayList<Passageiro> p) {
	//		for (int i=-1 ; i<15 ; i++) {
	//			for(int j=0;j<p.size();j++) {
	//				if(p.get(j).getOrigem() == i)
	//					andares[i+1].add(p.get(j));
	//			}
	//		}
	//	}

	public Elevador getE1() {
		return e1;
	}

	public Elevador getE2() {
		return e2;
	}

	public Elevador getE3() {
		return e3;
	}
}
