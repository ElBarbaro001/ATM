package Cliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Cliente {
	final String cliente ="localhost";
	final int puerto = 5000;
	DataInputStream recibir;
	DataOutputStream enviar;
	String mensaje;
	public void iniciarCliente() {
		Scanner leer = new Scanner(System.in);
		try {
			Socket sc = new Socket(cliente,puerto);
			recibir = new DataInputStream(sc.getInputStream());
			enviar = new DataOutputStream(sc.getOutputStream());
			String teclado = "";
			System.out.println("Leer instrucciones");
			while(teclado.equals("x")) {
				teclado = leer.nextLine();
				enviar.writeUTF(teclado);
				mensaje = recibir.readUTF();
				System.out.println(mensaje);				
			}
			sc.close();
		}catch(IOException ex) {
			//
		}
	}
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.iniciarCliente();
	}

}
