package it.unisa.controller.carrello;

import java.io.IOException;


import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.utils.Carrello;



/**
 * Servlet implementation class CancellaProdCarrelloServlet
 */
@WebServlet("/cancelladacarrello")
public class CancellaProdCarrelloServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	private static ProdottoDAO model;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		model= new ProdottoDAOImpl();
		
		//Recupero la sessione
		HttpSession session = request.getSession();
				 
	
			//Recupero il carrello dalla sessione ed elimino il prodotto con l'id ricevuto dal carrello
					
			Carrello carrello = (Carrello) session.getAttribute("carrello");
					
			if(request.getParameter("id") != null)
			{
				
				int id = Integer.parseInt(request.getParameter("id"));
						
				try 
				{
							
					carrello.cancellaProdotto(model.getProdottoById(id));	
						
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			
					
				
			response.sendRedirect(this.getServletContext().getContextPath()+"/carrello");
		
		}
				
	}


}
