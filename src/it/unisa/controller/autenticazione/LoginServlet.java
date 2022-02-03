package it.unisa.controller.autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.unisa.model.beans.Utente;
import it.unisa.model.dao.UtenteDAO;
import it.unisa.model.dao.UtenteDAOImpl;
import it.unisa.model.helper.HashPassword;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginutente")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO model;
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new UtenteDAOImpl();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente = null;
		
		HttpSession currentSession = request.getSession(); //recupero la sessione
		
		if(currentSession.getAttribute("user") == null)
		{
			try 
			{
				HashPassword criptator = new HashPassword(password);
				utente =model.getByEmailAndPassword(email, criptator.cryptWithSHA512());

				if(utente == null)
				{
					
					currentSession.setAttribute("messaggioLogin", "Login fallito, riprova!");
					response.sendRedirect(this.getServletContext().getContextPath()+ "/login");
				}
				else if(utente.isRuoloUtente()) //ADMIN
				{
					currentSession.setMaxInactiveInterval(60*60*24); //24h
					utente.setPasswordUtente(null);
					utente.setListaOrdini(null);
					currentSession.setAttribute("utente", utente);
					response.sendRedirect(this.getServletContext().getContextPath()+ "/dashboard");
				}
				else //Utente registrato
				{
					currentSession.setMaxInactiveInterval(60*60*24);//24h
					utente.setPasswordUtente(null);
					currentSession.setAttribute("utente", utente);
					response.sendRedirect(this.getServletContext().getContextPath()+"/index");
				}
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
	}
	
	
	
	
}
