package it.unisa.controller.categoria;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.utils.CatalogoProdotti;

/**
 * Servlet implementation class OrdinaCategoriaServlet
 */
@WebServlet("/ordinacategoria")
public class OrdinaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ProdottoDAO model = new ProdottoDAOImpl();
	    
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			CatalogoProdotti catalogo = null;
			String order="";
		
			try 
			{
				
				int idCategoria= Integer.parseInt(request.getParameter("idCat"));
				order = request.getParameter("order");
				catalogo = model.getAllProdottiByCategoria(idCategoria, order);
				
					
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				  String json = new Gson().toJson(catalogo);

				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    response.getWriter().write(json);
		
			
			
			
		}

}
