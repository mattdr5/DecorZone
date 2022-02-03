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
import it.unisa.model.helper.HashPassword;

/**
 * Servlet implementation class ModificaPasswordUtenteServlet
 */
@WebServlet("/modificapassword")
public class ModificaPasswordUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtenteDAO model;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model= new UtenteDAOImpl();
		
		HttpSession session = request.getSession(false);
		
		Utente user  = (Utente) session.getAttribute("utente");
		
		
		String password = request.getParameter("password1");
		String email = user.getEmailUtente();
		
		
		String mex = "";
		try {
			
			HashPassword criptatore = new HashPassword(password); // utilizzo per criptare password
			if(model.modificaPasswordUtente(email, criptatore.cryptWithSHA512()))
			{
				session.invalidate();
				request.setAttribute("messaggioPassw", "Password aggiornata! Rilogga");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				mex= "Attenzione c'è stato qualche errore. Riprova!";
				session.setAttribute("messaggioModifica", mex);
				response.sendRedirect("accountUtente.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
