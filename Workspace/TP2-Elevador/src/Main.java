import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static final String NOME_ARQUIVO = "entrada.txt";
	
	public static void main(String[] args) {
		// TODO Implementar logica
		
		ArrayList<Pedido> pedidos = retornaArquivo(NOME_ARQUIVO);
		
		

	}
	
	public static synchronized Pedido nextPedido() {
		//TODO sincronizacao
		return new Pedido(1,2,3);
	}
	
 	public static ArrayList<Pedido> retornaArquivo(String fileName){

		try {
			//Abrindo leitura do arquivo texto
			FileInputStream fileIn = new FileInputStream(fileName);
			DataInputStream entry = new DataInputStream(fileIn);
			
			ArrayList<Pedido> pedidosList = new ArrayList<>();
			
			while(entry.available()!=0) {
				StringTokenizer st = new StringTokenizer(entry.readLine(),",");

				//Tratando andares com nome de letras T e P transformando em -1 e 0 respectivamente
				String origemS = st.nextToken();
				int origemI = (origemS=="T")?-1: (origemS=="P")?0:Integer.parseInt(origemS); ;
				String destinoS = st.nextToken();
				int destinoI = (destinoS=="T")?-1: (destinoS=="P")?0:Integer.parseInt(destinoS); ;
				
				
				String intervalo = st.nextToken();
				pedidosList.add(new Pedido(origemI,destinoI,Integer.parseInt(intervalo)));
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
