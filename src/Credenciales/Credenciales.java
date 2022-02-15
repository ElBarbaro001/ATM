package Credenciales;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
public class Credenciales {
	Connection conectar = null;
	final String usuario = "xroot";
	final String clave = "root";
	final String controlador = "org.postgresql.Driver";
	final String url = "jdbc:postgresql://localhost:5432/proyecto";
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conectar = DriverManager.getConnection(url, usuario, clave);
			if(conectar != null) {
				System.out.println("Hecho");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public void validarCredenciales() throws IOException{
		try {
			Class.forName(controlador);
			Connection conectar = DriverManager.getConnection(url, usuario, clave);
			Statement query = conectar.createStatement();
			ResultSet resultado = query.executeQuery("select * from public.loggin");
			if(resultado.next() == true) {
				String U = resultado.getString("Usuario");
				String C = resultado.getString("Clave");
				System.out.println(U+"\n"+C);
			}
			resultado.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	public void validarUsuario(String user) throws IOException{
		String u = "";
		String c = "";
		try {
			Class.forName(controlador);
			Connection conectar = DriverManager.getConnection(url, usuario, clave);
			//Statement query = conectar.createStatement();
			String sql = "select * from public.loggin where usuario='"+user+"'";
			Statement statement = conectar.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultado = statement.executeQuery(sql);
			/*
			if(resultado.next() == true) {
				u = resultado.getString("usuario");
				c = resultado.getString("clave");
			}
			*/
			
			System.out.println("Usuario Logueado -> "+u);
			System.out.println("Clave de Usuario -> "+c);
			if(resultado.next() == true) {
				System.out.println("Usuario valido");
			}
			/*
			if(resultado.first()) {
				System.out.println("Acceso Autorizado");
			}else {
				System.out.println("Acceso Denegado a "+user+" no existe.");
			}
			*/
			resultado.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void leer(String pos, ResultSet result) throws SQLException {
		String usuario = result.getString("Usuario");
		String clave = result.getString("Clave");
	}
}