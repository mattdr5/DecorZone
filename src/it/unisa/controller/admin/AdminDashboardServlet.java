package it.unisa.controller.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.dao.OrdineDAO;
import it.unisa.model.dao.OrdineDAOImpl;
import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.dao.UtenteDAO;
import it.unisa.model.dao.UtenteDAOImpl;


/**
 * Servlet implementation class AdminDashboardServlet
 */
@WebServlet("/dashboard")
public class AdminDashboardServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private OrdineDAO modelOrdine;
	private ProdottoDAO modelProd;
	private UtenteDAO modelUtente;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		modelOrdine = new OrdineDAOImpl();
		modelProd = new ProdottoDAOImpl();
		modelUtente= new UtenteDAOImpl();
		
		
		
		int numOrdini = 0;
		int numProd = 0;
		int numUsers = 0;
		
		try 
		{
			numOrdini = modelOrdine.contaOrdini();
			numProd = modelProd.contaProdotti();
			numUsers = modelUtente.contaUtenti();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("numOrdini", numOrdini);
		request.setAttribute("numProd", numProd);
		request.setAttribute("numUtenti", numUsers);
		request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);
		
		
	}


}
