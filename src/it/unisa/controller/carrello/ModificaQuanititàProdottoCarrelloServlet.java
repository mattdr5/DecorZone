package it.unisa.controller.carrello;

import java.io.IOException;


import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.utils.Carrello;



/**
 * Servlet implementation class ModificaQuanititàProdottoCarrelloServlet
 */
@WebServlet("/modificaquanititacarrello")
public class ModificaQuanititàProdottoCarrelloServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private static ProdottoDAO model = new ProdottoDAOImpl();  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
			
			Carrello carrello = (Carrello) session.getAttribute("carrello");
			String tempId = request.getParameter("id");
			String tempNewQuantita = request.getParameter("numProdOrd");
			if(tempNewQuantita!=null && tempId!=null)
			{
	
				int id= Integer.parseInt(tempId);
				int newQuantita = Integer.parseInt(tempNewQuantita);
				try 
				{
				 if(newQuantita >= 0 )
				 {
					if(model.getDisponibilitaProdotto(id, newQuantita))
					{
						
						carrello.modificaQuantitaProdotto(model.getProdottoById(id), newQuantita);
						session.setAttribute("messaggio", "true");
						session.setAttribute("carrello", carrello);
						
					}
					else
					{
						session.setAttribute("messaggio", "false");
					}
				 }
				 else
				 {
					 session.setAttribute("messaggio", "negQuant");
				 }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
			
		
			response.sendRedirect(this.getServletContext().getContextPath()+"/carrello");
		
	}

}
