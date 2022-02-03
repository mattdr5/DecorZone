package it.unisa.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Ordine;
import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;



/**
 * Servlet implementation class VisualizzaOrdiniServlet
 */
@WebServlet("/ordiniadmin")
public class VisualizzaOrdiniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OrdineDAO model = new OrdineDAOImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Ordine> listaOrdini = null;
		
		String start = request.getParameter("data1");
		String end = request.getParameter("data2");
		if(start == null || start.isEmpty() || end.isEmpty() || end ==null)
		{
			try 
			{
				listaOrdini = model.getAllOrdini();
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else
		{
			try 
			{
				listaOrdini = model.getAllOrdini(start,end);
			
			} 
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		request.setAttribute("ordini", listaOrdini);
		request.getRequestDispatcher("viewOrdersAdmin.jsp").forward(request, response);
		
	}

}
