package it.unisa.controller.checkout;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.dao.CartaDAO;
import it.unisa.model.dao.CartaDAOImpl;

/**
 * Servlet implementation class ValidaEmailServlet
 */
@WebServlet("/validacarta")
public class ValidaCartaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartaDAO model;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new CartaDAOImpl();
		boolean presente = false;
		
		String num = request.getParameter("numCarta");
		System.out.println(num);
		if(!num.trim().equals("") && num!=null) 
		{
			
			try
			{
				if(model.checkCarta(num))
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
