package it.unisa.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Utente;
import it.unisa.model.dao.UtenteDAO;
import it.unisa.model.dao.UtenteDAOImpl;


/**
 * Servlet implementation class VisualizzaUtentiServlet
 */
@WebServlet("/utentiAdmin")
public class VisualizzaUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO model;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new UtenteDAOImpl();
		ArrayList<Utente> listaUtenti = null;
		
		
		
		try 
		{
			listaUtenti = model.getAllUsers();
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("utenti", listaUtenti);
		request.getRequestDispatcher("viewUsersAdmin.jsp").forward(request, response);
		
		
		
		
		
	}



}
