import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static final String NOME_ARQUIVO = "entrada.txt";
	public static ArrayList<Passageiro> demanda;
	public static ArrayList<Passageiro> atendidos;
	public static long initialTime,horario;



	public static void main(String[] args) throws InterruptedException {
		demanda = retornaArquivo(NOME_ARQUIVO);
		Elevador[] e = new Elevador[3];
		for(int i=0; i<3 ;i++) {
			e[i] = new Elevador("Elevador "+i,getFirst());
		}
		
	}

	public static synchronized Passageiro getFirst() {
//		boolean atendido = true;
		for(int i=0; i<demanda.size() /*&& atendido*/;i++) {
			if(!demanda.get(i).isAtendido()) {
				return demanda.get(i);
			}
		}
		return null;
	}


	public static synchronized Passageiro availableOnFloor(int floor, long time) {
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

	public static synchronized ArrayList<Passageiro> ordena(ArrayList<Passageiro> p) throws InterruptedException {

		ArrayList<Passageiro> ordenada = new ArrayList<>();
		Passageiro smallest;
		int index=0;
		while(!p.isEmpty()) {
			Thread.sleep(200);
			smallest = p.get(0);
			for(int i=0;i<p.size();i++) {
				if(p.get(i).getIntervalo()<smallest.getIntervalo()) {
					smallest=p.get(i);
					index=i;	
				}
			}
			System.out.println("ordenada "+ordenada.size()+" \tp:"+p.size()+" \t="+(ordenada.size()+p.size())+" \tindex:"+index+" \tID: "+p.get(index).getIntervalo());

			ordenada.add(p.remove(index));
		}
		return ordenada;
	}

	public static ArrayList<Passageiro> retornaArquivo(String fileName){
		try {
			//Abrindo leitura do arquivo texto
			FileInputStream fileIn = new FileInputStream(fileName);
			DataInputStream entry = new DataInputStream(fileIn);

			ArrayList<Passageiro> pedidosList = new ArrayList<>();
			int id=0;
			while(entry.available()!=0) {
				id++;
				StringTokenizer st = new StringTokenizer(entry.readLine(),",");

				//Tratando andares com nome de letras T e P transformando em -1 e 0 respectivamente
				String origemS = st.nextToken();
				int origemI = (origemS.equalsIgnoreCase("t"))?-1: (origemS.equalsIgnoreCase("p"))?0:Integer.parseInt(origemS); ;
				String destinoS = st.nextToken();
				int destinoI = (destinoS.equalsIgnoreCase("t"))?-1: (destinoS.equalsIgnoreCase("p"))?0:Integer.parseInt(destinoS); ;


				String intervalo = st.nextToken();
				pedidosList.add(new Passageiro(id,origemI,destinoI,Integer.parseInt(intervalo)));
			}
			return pedidosList;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
