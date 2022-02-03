package it.unisa.controller.prodotto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.utils.CatalogoProdotti;

/**
 * Servlet implementation class CercaProdottoServlet
 */
@WebServlet("/risultatiricerca")
public class CercaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDAO model;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new ProdottoDAOImpl();
		String searchText = request.getParameter("search");
		CatalogoProdotti catalogo = null;
		
		if(searchText != null)
		{
			if(searchText.equals(""))
			{
				searchText="tutti i prodotti";
			}
			try 
			{
				catalogo = model.cercaProdotto(searchText);
				request.setAttribute("catalogo", catalogo);
				request.setAttribute("ricerca-text", searchText);
				request.getRequestDispatcher("risultatiRicerca.jsp").forward(request, response);
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

}
