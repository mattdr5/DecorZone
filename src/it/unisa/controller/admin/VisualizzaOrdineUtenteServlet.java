package it.unisa.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Ordine;
import it.unisa.model.beans.Utente;
import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;
import it.unisa.model.dao.UtenteDAO;
import it.unisa.model.dao.UtenteDAOImpl;



/**
 * Servlet implementation class VisualizzaOrdineUtenteServlet
 */
@WebServlet("/ordineutente")
public class VisualizzaOrdineUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OrdineDAO model = new OrdineDAOImpl();
    private static UtenteDAO userModel = new UtenteDAOImpl(); 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("user");
		
		ArrayList<Ordine> listaOrdini = null;
		
		Utente user = null;
		
		try 
		{
			listaOrdini = model.getOrdine(email);
			user = userModel.getById(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("user", user);
		request.setAttribute("ordiniUtente", listaOrdini);
		request.getRequestDispatcher("viewOrdersUserAdmin.jsp").forward(request, response);
		
	}

	

}
