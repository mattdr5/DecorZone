package it.unisa.controller.registrazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Utente;
import it.unisa.model.dao.UtenteDAO;
import it.unisa.model.dao.UtenteDAOImpl;
import it.unisa.model.helper.HashPassword;



/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtenteDAO model;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new UtenteDAOImpl();
		boolean aggiunto= false;
		
		//Ricevo i parametri dal form registrazione 
		String nome = request.getParameter("name");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String numeroTelefono = request.getParameter("numTel");
		
		Utente newUser = new Utente();
		try 
		{
			newUser.setEmailUtente(email);
			newUser.setNomeUtente(nome);
			newUser.setCognomeUtente(cognome);
			
			HashPassword criptatore = new HashPassword(password); // utilizzo per criptare password
			newUser.setPasswordUtente(criptatore.cryptWithSHA512());
			newUser.setNumeroTelefonoUtente(numeroTelefono);
			newUser.setRuoloUtente(false);
			
			//Inserisco nel database
			if(model.insert(newUser))
			{
				aggiunto = true; //Inserimento tutto ok!
			}
			
		} 
		catch (SQLException e) { e.printStackTrace();}
		
		if(aggiunto)
		{
		
			request.getRequestDispatcher("registrazioneSuccess.jsp").forward(request, response);
			
		}
		else
		{
			
		}
		
		
		//TODO:
		/*Se la registrazione è avvenuta con successo
		* porto l'utente alla pagina di registrazione avvenuta, 
		* una volta effettuato l'accesso il cliente può utilizzare il suo account
		*/
	}

}
