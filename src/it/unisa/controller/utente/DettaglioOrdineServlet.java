package it.unisa.controller.utente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.beans.Utente;
import it.unisa.model.dao.DettaglioOrdineDAO;
import it.unisa.model.dao.DettaglioOrdineDAOImpl;

/**
 * Servlet implementation class DettaglioOrdineServlet
 */
@WebServlet("/dettaglioordine")
public class DettaglioOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DettaglioOrdineDAO model = new DettaglioOrdineDAOImpl(); 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession currentSession = request.getSession();
		
		Utente currentUser = (Utente) currentSession.getAttribute("utente");
		
		if(currentUser == null)
		  {
		    response.sendRedirect("login.jsp");
		  }
		  else
		  {
		
		String idtemp =  request.getParameter("id");
		
		int idOrdine = Integer.parseInt(idtemp);
				
		
		try 
		{
			
			request.setAttribute("prodotti", model.getOrdineProdotti(idOrdine));
			request.setAttribute("idOrder", idOrdine);
		}
		catch (SQLException e) 
		{
			
			System.out.println("Error:" + e.getMessage());
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dettaglioOrdine.jsp");
		dispatcher.forward(request, response);	
	}
	}
}
