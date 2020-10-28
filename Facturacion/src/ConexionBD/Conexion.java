package ConexionBD;
import java.sql.*;
public class Conexion {
	Connection con;
	String url = "jdbc:mysql://localhost:3306/facturacion";
    String Driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String clave = "";

	public Conexion(){
	        try {
	        	Class.forName(Driver);
	        	con = DriverManager.getConnection(url, user, clave);
	        } catch (Exception e) {
	            System.err.println("Error:" +e);
	        }
	    }

	
	public Connection getConnection() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return Driver;
	}

	public void setDriver(String driver) {
		Driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
