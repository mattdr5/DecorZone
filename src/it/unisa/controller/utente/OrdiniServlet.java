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
import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;

/**
 * Servlet implementation class OrdiniServlet
 */
@WebServlet("/imieiordini")
public class OrdiniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OrdineDAO model = new OrdineDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		String email = (String) currentUser.getEmailUtente();
		
		try 
		{
			
			request.setAttribute("ordini", model.getOrdine(email));
			
		}
		catch (SQLException e) 
		{
			
			System.out.println("Error:" + e.getMessage());
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ordiniUtente.jsp");
		dispatcher.forward(request, response);	
	}
	}

}
