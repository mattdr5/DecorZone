package it.unisa.controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Ordine;
import it.unisa.model.dao.DettaglioOrdineDAO;
import it.unisa.model.dao.DettaglioOrdineDAOImpl;
import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;



/**
 * Servlet implementation class VisualizzaDettaglioOrdineAdminServlet
 */
@WebServlet("/visualizzadettagliordine")
public class VisualizzaDettaglioOrdineAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OrdineDAO orderModel = new OrdineDAOImpl();
	private static DettaglioOrdineDAO dettaglioModel = new DettaglioOrdineDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		Ordine ordine = null;
		
		
		try 
		{
			ordine = orderModel.getOrdineById(id);
			ordine.setDettagliOrdine(dettaglioModel.getOrdineProdotti(id));
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("ordine", ordine);
		request.getRequestDispatcher("viewDettagliOrdineAdmin.jsp").forward(request, response);
		
	}

}
