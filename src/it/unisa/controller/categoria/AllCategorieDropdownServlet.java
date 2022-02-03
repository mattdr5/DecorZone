package it.unisa.controller.categoria;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.unisa.model.beans.Categoria;
import it.unisa.model.dao.CategoriaDAO;
import it.unisa.model.dao.CategoriaDAOImpl;

/**
 * Servlet implementation class AllCategorieServlet
 */
@WebServlet("/allcategoriedropdown")
public class AllCategorieDropdownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoriaDAO model;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new CategoriaDAOImpl();
		ArrayList<Categoria> listaCategorie = null;
		
		try 
		{
			listaCategorie = model.getAllCategorie();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  String json = new Gson().toJson(listaCategorie);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		
	}


}
