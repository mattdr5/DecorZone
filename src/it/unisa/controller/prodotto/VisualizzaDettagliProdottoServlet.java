package it.unisa.controller.prodotto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Prodotto;
import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;


/**
 * Servlet implementation class VisualizzaDettagliProdottoServlet
 */
@WebServlet("/dettagliprodotto")
public class VisualizzaDettagliProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDAO model;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			model = new ProdottoDAOImpl();
			Prodotto prodotto = null;
			String idProd = "";
		
			idProd = request.getParameter("id");
			
			
				try 
				{
					int id = Integer.parseInt(idProd);
					prodotto = model.getProdottoById(id);
					request.setAttribute("prodotto", prodotto);
					request.getRequestDispatcher("viewDettagliProdotto.jsp").forward(request, response);
					
					
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


