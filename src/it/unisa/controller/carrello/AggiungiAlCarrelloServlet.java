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
 * Servlet implementation class AggiungiInCarrelloServlet
 */
@WebServlet("/aggiungialcarrello")
public class AggiungiAlCarrelloServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ProdottoDAO model;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		model = new ProdottoDAOImpl();
		
		//Recupero la sessione
		HttpSession session = request.getSession();
		 
	
		/* Recupero il carrello dalla sessione, se non è presente nella sessione devo crearlo ed aggiungerlo alla sessione*/
			
		Carrello carrello = (Carrello) session.getAttribute("carrello");				
      	
	     if(carrello == null) 
	      {
	      		carrello = new Carrello();
	      		
	      		session.setAttribute("carrello", carrello);
	      }
	      	
	   //Aggiungo prodotto
			String text = "";
			String idTemp = request.getParameter("id");
			if(idTemp == null || idTemp.trim().equals(""))
			{
				text= "Errore!";
			}else
			{
				int id = Integer.parseInt(idTemp.trim());
				
				try 
				{
					carrello.aggiungiProdotto(model.getProdottoById(id));
					carrello.calcolaTotaleCarrello();
					text= "Prodotto aggiunto al carrello!";
					
				} catch (SQLException e) 
				{
					text= "C'è stato qualche errore!";
					e.printStackTrace();
				}
				
				
			}
		
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    response.getWriter().write(text);       // Write response body.
	}
	
}
