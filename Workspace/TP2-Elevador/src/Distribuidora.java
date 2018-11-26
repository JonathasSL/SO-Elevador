import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Distribuidora {
	private static ArrayList<Passageiro> demanda;

	public Distribuidora(ArrayList<Passageiro> demanda) {
		setDemanda(demanda);
	}
	
	public static synchronized boolean finished() {
		for(int i=0; i<demanda.size() ;i++) {
			if(!demanda.get(i).isAtendido())
				return false;
		}
		return true;
	}
	
	public static synchronized Passageiro getNext() {
		if(!finished())
			for(int i=0; i<demanda.size() ;i++) {
				if(!demanda.get(i).isAtendido()) {
					demanda.get(i).setAtendido(true);
					return demanda.get(i);
				}
			}
		return null;
	}

	public static synchronized ArrayList<Passageiro> getDemanda() {
		return demanda;
	}
	public static synchronized void setDemanda(ArrayList<Passageiro> demanda) {
		Distribuidora.demanda = demanda;
	}

	
	
}
