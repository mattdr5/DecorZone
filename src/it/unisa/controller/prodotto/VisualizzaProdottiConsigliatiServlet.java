package it.unisa.controller.prodotto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.unisa.model.beans.Prodotto;
import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;


/**
 * Servlet implementation class VisualizzaProdottiConsigliatiServlet
 */
@WebServlet("/consigli")
public class VisualizzaProdottiConsigliatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProdottoDAO model;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new ProdottoDAOImpl();
		ArrayList<Prodotto> consigliati = null;
		
		try 
		{
			consigliati = model.getProdottiConsigliati();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  String json = new Gson().toJson(consigliati);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
	}


}
