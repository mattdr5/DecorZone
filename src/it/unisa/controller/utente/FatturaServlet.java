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

import it.unisa.model.beans.Ordine;
import it.unisa.model.beans.Utente;
import it.unisa.model.dao.DettaglioOrdineDAO;
import it.unisa.model.dao.DettaglioOrdineDAOImpl;
import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;

/**
 * Servlet implementation class FatturaServlet
 */
@WebServlet("/fattura")
public class FatturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OrdineDAO ordineModel = new OrdineDAOImpl();
	private static DettaglioOrdineDAO dettaglioModel = new DettaglioOrdineDAOImpl();
	

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession currentSession = request.getSession();
		
		Utente currentUser = (Utente) currentSession.getAttribute("utente");
		
		
		if(currentUser == null)
		  {
		    response.sendRedirect(this.getServletContext().getContextPath()+"/login");
		  }
		  else
		  {
		
			  
		String idtemp =  request.getParameter("id");
		String email = (String) currentUser.getEmailUtente();

		int idOrdine = Integer.parseInt(idtemp);
				
		
		try 
		{
			Ordine temp = ordineModel.getOrdineById(idOrdine);
			
			if(temp.getEmail().compareTo(email) == 0)
			{
			request.setAttribute("ordine", ordineModel.getOrdineById(idOrdine));
			
			request.setAttribute("prodotti", dettaglioModel.getOrdineProdotti(idOrdine));
			
			request.setAttribute("user", currentUser);
			}
			
		}
		catch (SQLException e) 
		{
			
			System.out.println("Error:" + e.getMessage());
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fattura.jsp");
		dispatcher.forward(request, response);	
	}
	}
}
