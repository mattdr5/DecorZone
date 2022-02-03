package it.unisa.controller.utente;

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

/**
 * Servlet implementation class ModificaInformazioniServlet
 */
@WebServlet("/modificainfoutente")
public class ModificaInformazioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO model;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model= new UtenteDAOImpl();
		
		HttpSession session = request.getSession(false);
		
		Utente user  = (Utente) session.getAttribute("utente");
		
		
		String nome = request.getParameter("nomeUtente");
		String cognome = request.getParameter("cognomeUtente");
		String numTel = request.getParameter("numTelUtente");
		String email = user.getEmailUtente();
		
		
		String mex = "";
		try {
			if(model.modificaDatiUtente(email, nome, cognome, numTel))
			{
				mex= "Dati utente modificati con successo!";
				Utente userUpdating = new Utente();
				userUpdating.setNomeUtente(nome);
				userUpdating.setCognomeUtente(cognome);
				userUpdating.setNumeroTelefonoUtente(numTel);
				userUpdating.setEmailUtente(email);
				if(user.isRuoloUtente())
				{
					userUpdating.setRuoloUtente(true);
				}
				session.setAttribute("utente", userUpdating);
			}
			else
			{
				mex= "Attenzione c'è stato qualche errore";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		session.setAttribute("messaggioModifica", mex);
		response.sendRedirect(this.getServletContext().getContextPath()+"/ilmioaccount");
		
	}

}
