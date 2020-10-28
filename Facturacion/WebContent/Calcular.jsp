<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="ConexionBD.*"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
    integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

<title>Calcular</title>
</head>
	
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Facturación</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item active">
	        <a class="nav-link" href="factura.jsp">Inicio<span class="sr-only"></span></a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="agregar.jsp">Agregar Producto<span class="sr-only"></span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="login.jsp">Salir</a>
	      </li>
	    </ul>
	    <!--<form class="form-inline my-2 my-lg-0" action="#">
	      <input class="form-control mr-sm-2" type="search" placeholder="Cuantos productos Vendera" name="numero" >
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Refrescar</button>
	    </form>-->
	  </div>
	</nav>
	
	<div class="container" style="margin-top:20px;">
	  <div class="row">
	    <div class="col">
	      Cantidad
	    </div>
	    <div class="col">
	      Producto
	    </div>
	    <div class="col">
	      Precio
	    </div>
	  </div>
	</div>
	
	<% 
	int n;
	int total=0;

	n = Integer.parseInt(request.getParameter("NdePedidos"));
	 
	 Conexion cn=new Conexion();
	 Connection con;
	 PreparedStatement ps;
	 ResultSet rsl;  
	 int j=n;
	 for (int i = 0; i < n ; ++i) { 
		 if(request.getParameter("producto"+i).compareTo("Elegir")== 0){
			 j--;
		 }
	 }
	%>
	<!--  action="<% //request.getContextPath()%>/rptProductos" -->
	<form action="<%=request.getContextPath()%>/Productos" method="post">
		<%
		for (int i = 0; i < j; ++i) { %>
			<div class="container">
			  <div class="row">
			    <div class="col">
			    	<h5><%=request.getParameter("cantidad"+i)%></h5>
			    	<input type="hidden" name="cantidad<%=i%>" value="<%=request.getParameter("cantidad"+i)%>">
			    </div>
			    <div class="col">
			    	<h5><%=request.getParameter("producto"+i)%></h5>
			    	<input type="hidden" name="producto<%=i%>" value="<%=request.getParameter("producto"+i)%>">
			    </div>
			    <div class="col">
				    <%
				      		int calculo=0;
				      		try {
				      				String sql ="select * from producto where Nombre = '"+ request.getParameter("producto"+i)+" ' ";
				      				con=cn.getConnection();
								    ps=con.prepareStatement(sql);
								    rsl=ps.executeQuery();
								    boolean resp=rsl.next();
								    System.out.println(resp);
								    calculo=rsl.getInt(3)*Integer.parseInt(request.getParameter("cantidad"+i));
							     } catch (Exception e) {
							         System.err.println("Error:" +e);
							     }
				      		total=total+ calculo;
				      %>
			       <h5><%=calculo%></h5>
			       <input type="hidden" name="subTotal<%=i%>" value="<%=calculo%>">
			    </div>
			  </div>
			</div>
		<% }%>
		<div class="container" style="margin-top:20px;">
	  <div class="row">
	    <div class="col">
	      <h5>Total</h5>
	    </div>
	    <div class="col">
	      
	    </div>
	    <div class="col">
	       <h5><%=total %></h5>
	        <input type="hidden" name="total" value="<%=total%>">
	    </div>
	  </div>
		</div>
		<input type="hidden" name="NdePedidos" value="<%=j %>">
		 <div class="row justify-content-around" style="margin-top:20px;">
		    <div class="col-11">
		      <!-- <button type="submit" class="btn btn-primary">Inprimir</button> -->
		    </div>
		  </div>
	</form>
</body>
</html>