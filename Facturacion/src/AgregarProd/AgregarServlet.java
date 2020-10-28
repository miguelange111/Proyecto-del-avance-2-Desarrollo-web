package AgregarProd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import ConexionBD.Conexion;
import static java.lang.System.out;
/**
 * Servlet implementation class AgregarServlet
 */
@WebServlet("/AgregarServlet")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Conexion cn=new Conexion();
		Conexion cn1=new Conexion();
		 Connection con;
		 Connection con1;
		 PreparedStatement ps;
		 ResultSet rsl;
		 Statement smt;
		 String NombrePro = request.getParameter("NombrePro");
		 String PresioPro = request.getParameter("PresioPro");
		 
		    try {
		    	String sql ="select * from producto where Nombre = '"+NombrePro +" ' ";
  				con=cn.getConnection();
			    ps=con.prepareStatement(sql);
			    rsl=ps.executeQuery();
			    boolean resp=rsl.next();
			    if(resp) {
			    	out.println("<script>");
					out.println("alert('Ocurrio un error se repitio nombre');");
					out.println("</script>");
					response.sendRedirect("factura.jsp");
					ps.close();
			    }else {
			    	sql ="INSERT INTO producto (Nombre, Precio) " + 
		    		"VALUES ('"+NombrePro+"','"+ PresioPro+"');";
			    	con1=cn1.getConnection();
					smt=con1.createStatement();
					smt.executeUpdate(sql);
					out.println("<script>");
					out.println("alert('Se guardo correctamente el producto');");
					out.println("</script>");
					response.sendRedirect("factura.jsp");
					}
		    	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}

}
