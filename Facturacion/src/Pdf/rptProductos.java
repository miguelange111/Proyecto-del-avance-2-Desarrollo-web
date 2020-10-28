package Pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfNull;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableFooter;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.corba.se.impl.orb.ParserTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.*;
import java.sql.*;

/**
 * Servlet implementation class rptProductos
 */
@WebServlet("/Productos")
public class rptProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rptProductos() {
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
		
		//
		/**		int j = Integer.parseInt(request.getParameter("NdePedidos"));
			String encabezado="Factura"+"\n"+"Total"+j;
			
			Font fuente = new Font(Font.getFamily("ARIAL"),12,Font.BOLD);
			
			Paragraph linea = new Paragraph(encabezado,fuente);
			
			PdfPTable tabla = new PdfPTable(3);
			tabla.setWidthPercentage(100);
			
			Document documento = new Document(PageSize.A4);
			
			String file="C:\\Users\\ASUS\\Downloads";
			try {
			PdfWriter.getInstance(documento, new FileOutputStream(file));
			
		PdfPCell celda1 =new PdfPCell(new Paragraph("Cantidad",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.RED)));
			PdfPCell celda2 =new PdfPCell(new Paragraph("Nombre",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.RED)));
			PdfPCell celda3 =new PdfPCell(new Paragraph("SubTotal",FontFactory.getFont("arial",10,Font.BOLD,BaseColor.RED)));
			
			documento.open();
			documento.add(linea);
			tabla.addCell(celda1);
			tabla.addCell(celda2);
			tabla.addCell(celda3);
			//
				for (int i = 0; i < j; ++i) {
				tabla.addCell(request.getParameter("cantidad"+i));
				tabla.addCell(request.getParameter("producto"+i));
				tabla.addCell(request.getParameter("subTotal"+i));
			}
			
			documento.add(tabla);
			documento.close();
			
			PrintWriter out = null;
			out.println("<script>");
			out.println("alert('Se generó exitosamente el archivo PDF..');");
			out.println("</script>");
			response.sendRedirect("factura.jsp");
			
		} catch (FileNotFoundException   | DocumentException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			int j = Integer.parseInt(request.getParameter("NdePedidos"));
			String encabezado="Factura"+"\n"+"Total"+j;
			PDDocument documento = new PDDocument();
			//PDPage pagina=new PDPage(PDRectangle.A4);
			//documento.addPage(pagina);
			
			String file="C:\\Users\\ASUS\\Downloads\\pedido.pdf";
			
			//PDPageContentStream contenido =new PDPageContentStream (documento,pagina);
			
		//	contenido.beginText();
		//	contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
			//contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight()-52);
		//	contenido.showText(encabezado);
		//	contenido.close();
			
			documento.save(file);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
