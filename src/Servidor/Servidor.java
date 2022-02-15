package Servidor;
//Libreria Sockets
import java.net.Socket;
import java.net.ServerSocket;
//Librerias para manejar flujo de datos
import java.io.DataInputStream;
import java.io.DataOutputStream;
//Transferencia de Archivos
import java.io.DataInputStream;
import java.io.DataOutputStream;
import Credenciales.Credenciales;
public class Servidor {
	static int puerto = 5000;
	ServerSocket servidor;
	Socket sc;
	//Enviar y Recibir Datos
	DataInputStream recibir;
	DataOutputStream enviar;
	public void iniciarServidor() {
		try {
			servidor = new ServerSocket(puerto);
			sc = new Socket();
			System.out.println("-> 1 Enlace ...");
			sc = servidor.accept();
			System.out.println("-> 2 Cliente Conectado ...");
			recibir = new DataInputStream(sc.getInputStream());
			enviar = new DataOutputStream(sc.getOutputStream());
			String control = "", usuario="", opciones="";
			
			while(control.equals("")) {
				
				//Validar usuario del Sistema
				if(usuario.equals(usuario)) {
					System.out.println("Administrador");
				}else {
					System.out.println("Error!!!");
				}
			}
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor server = new Servidor();
		server.iniciarServidor();
	}
}
