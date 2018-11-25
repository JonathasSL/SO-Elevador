import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static final String NOME_ARQUIVO = "entrada.txt";
	private static ArrayList<Passageiro> pedidos;
	private static long initialTime;
	
	public static synchronized void main(String[] args) {
		

		Predio predio = new Predio(retornaArquivo(NOME_ARQUIVO));

		initialTime = System.currentTimeMillis();
		
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
