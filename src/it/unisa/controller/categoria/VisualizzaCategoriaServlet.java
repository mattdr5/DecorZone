package it.unisa.controller.categoria;

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
 * Servlet implementation class VisualizzaCategoriaServlet
 */
@WebServlet("/categoria")
public class VisualizzaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProdottoDAO model = new ProdottoDAOImpl();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CatalogoProdotti catalogo = null;
		String idCat = "";
	
		idCat = request.getParameter("id");
		
		
			try 
			{
				int id = Integer.parseInt(idCat);
				catalogo = model.getAllProdottiByCategoria(id);
				request.setAttribute("catalogo", catalogo);
				request.getRequestDispatcher("viewCategoria.jsp").forward(request, response);
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch( NumberFormatException e1)
			{
				response.sendError(404);
			}
	
		
		
		
	}



}
