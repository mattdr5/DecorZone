package it.unisa.controller.carrello;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.utils.Carrello;


/**
 * Servlet implementation class SvuotaCarrelloServlet
 */
@WebServlet("/svuotacarrello")
public class SvuotaCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		
			 Carrello carrello = (Carrello ) request.getSession().getAttribute("carrello");
		
			 carrello.svuotaCarrello();
			 
			 session.setAttribute("carrello", carrello);
			 request.setAttribute("carrello", carrello);
		
			 response.sendRedirect(this.getServletContext().getContextPath()+"/carrello");
			 
		
	}

}
