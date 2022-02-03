package it.unisa.controller.registrazione;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.dao.UtenteDAO;
import it.unisa.model.dao.UtenteDAOImpl;



/**
 * Servlet implementation class ValidaEmailServlet
 */
@WebServlet("/validaemail")
public class ValidaEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtenteDAO model;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new UtenteDAOImpl();
		boolean presente = false;
		
		String email = request.getParameter("email");
		System.out.println(email);
		if(!email.trim().equals("") && email!=null) 
		{
			
			try
			{
				if(model.checkEmail(email))
				{
					presente = true;
				}
				
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		response.setContentType("text/plain"); 
	    response.setCharacterEncoding("UTF-8"); 
		if(presente)
		{
		    response.getWriter().write("presente");       
		}
		else
		{
			response.getWriter().write("non-presente"); 
		}
		
		
		
	}

}
