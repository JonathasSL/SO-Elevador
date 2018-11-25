import java.util.ArrayList;

public class Predio {
	private Elevador e1,e2,e3;
	private ArrayList<Passageiro>[] andares;
	
	public Predio(ArrayList<Passageiro> p) {
		andares = new ArrayList[17];
		setAndares(p);
	}
	
	private void setAndares(ArrayList<Passageiro> p) {
		for (int i=-1 ; i<15 ; i++) {
			for(int j=0;j<p.size();j++) {
				if(p.get(j).getOrigem() == i)
					andares[i+1].add(p.get(j));
			}
		}
	}

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
