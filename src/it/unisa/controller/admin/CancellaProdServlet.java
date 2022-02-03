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

/**
 * Servlet implementation class dettagliProdottoServlet
 */
@WebServlet("/cancellaprod")
public class CancellaProdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private ProdottoDAO model;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new ProdottoDAOImpl();
		String idTemp = request.getParameter("id");	
		String text = "";
		try 
		{
			int id = Integer.parseInt(idTemp);
			model.cancellaProdotto(id);
			text= "true";
		} 
		catch (SQLException e) 
		{
			text="false";
			e.printStackTrace();
		}
		catch( NumberFormatException e1)
		{
			response.sendError(404);
		}
		
		request.getSession().setAttribute("mexDelete", text);
		response.sendRedirect(this.getServletContext().getContextPath()+"/catalogoAdmin");		
	}

}