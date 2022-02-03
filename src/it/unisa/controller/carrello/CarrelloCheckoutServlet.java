package it.unisa.controller.carrello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.utils.Carrello;

/**
 * Servlet implementation class CarrelloCheckoutServlet
 */
@WebServlet("/CarrelloCheckout")
public class CarrelloCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			/* Recupero la sessione e invio il carrello alla jsp */
			HttpSession session = request.getSession();
		
				
			     Carrello carrello = (Carrello) session.getAttribute("carrello");
			     if(carrello == null)
			     {
			      	
			    	carrello = new Carrello();
			      	session.setAttribute("carrello", carrello);
			     
			     }
			     
		 		request.setAttribute("carrello", carrello);

	      		request.getRequestDispatcher("checkout.jsp").forward(request, response);
			 
			
			
		}

		

	}
