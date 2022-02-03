package it.unisa.controller.checkout;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.beans.Carta;
import it.unisa.model.beans.Ordine;
import it.unisa.model.beans.Utente;
import it.unisa.model.dao.CartaDAO;
import it.unisa.model.dao.CartaDAOImpl;
import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;
import it.unisa.model.utils.Carrello;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static OrdineDAO model = new OrdineDAOImpl();
	  private static CartaDAO cardModel = new CartaDAOImpl();
	
	    
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			HttpSession session = request.getSession();
			
			String indirizzo= request.getParameter("indirizzo");
			String cap = request.getParameter("cap");
			String citta = request.getParameter("citta");
			
			String carta = request.getParameter("numCarta");
			
		
			String indirizzoSpedizione = citta +", "+ cap+ ", "+ indirizzo;	
			
			
				Carrello carrello = (Carrello) session.getAttribute("carrello");
				
				Utente utenteOrdine = (Utente) session.getAttribute("utente");
				
				Ordine nuovoOrdine = new Ordine();
				
				Carta card = new Carta();
				try 
				{
					 card = cardModel.getCarta(carta);
					 
					 if(card.getSaldo() >=  carrello.calcolaTotaleCarrello())
					 {
						 
					//Creo un nuovo ordine
					nuovoOrdine.setIdOrdine(model.getLastId()); //Recupero l'ultimo id dal Database
					nuovoOrdine.setDettagliOrdine(carrello.getProdottiCarrello());
					nuovoOrdine.setTotaleOrdine(carrello.calcolaTotaleCarrello());
					nuovoOrdine.setDataOrdine(LocalDateTime.now().toString().substring(0,10));
					nuovoOrdine.setIndirizzoSpedizione( indirizzoSpedizione);
					nuovoOrdine.setQuantitaTotaleOrdinata(carrello.calcolaQuantitaProdottiNelCarrello());
					nuovoOrdine.setEmail(utenteOrdine.getEmailUtente());
					
					//Inserisco il nuovo ordine nel Database
					if(model.insert(nuovoOrdine))
					{
						session.removeAttribute("carrello");
						request.setAttribute("mex", "true");
						request.getRequestDispatcher("acquistoSucces.jsp").forward(request, response);
						cardModel.acquista(carrello.calcolaTotaleCarrello());
					}
					else
					{
						request.setAttribute("mex", "false");
						request.getRequestDispatcher("acquistoSucces.jsp").forward(request, response);
					}
					
					}
					else
					{
						request.setAttribute("mex", "saldoInsuff");
						request.getRequestDispatcher("acquistoSucces.jsp").forward(request, response); 
				   }
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		}

		
	}

