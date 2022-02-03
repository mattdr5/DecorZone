package it.unisa.controller.admin;

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
 * Servlet implementation class viewCatalogoAdminServlet
 */
@WebServlet("/catalogoAdmin")
public class ViewCatalogoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ProdottoDAO model = new ProdottoDAOImpl();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sort = request.getParameter("sort");
		CatalogoProdotti catalogo = null;
		
		try 
		{
			
			catalogo = model.getAllProdotti(sort);
			
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			
		}
		
		request.setAttribute("catalogo", catalogo);
		request.getRequestDispatcher("viewCatalogoAdmin.jsp").forward(request, response);	
	}

	

}
