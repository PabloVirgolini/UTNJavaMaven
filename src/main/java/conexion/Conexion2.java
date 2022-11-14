
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion2 {
	private static Conexion2 instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="root";
	private String password="admin01admin";
	private String db="java";
	private int conectados=0;

	
	private Connection con;


	private Conexion2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getCon() {
		try {
			if(con==null || con.isClosed()) {
				con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
		} catch(Exception e) {
			System.out.println("Error al conectar a la base de datos" + e.getLocalizedMessage());
		}
	}
	
	public void desconectar() {
		conectados--;
		try {
			//if(!con.isClosed()) {
			if (conectados<=0) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Conexion2 getInstancia() {
		if (instancia == null) {
			instancia = new Conexion2();
		}
		return instancia;
	}
	
}
