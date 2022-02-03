package it.unisa.controller.admin;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.model.beans.Prodotto;
import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.helper.CaricatoreFoto;

/**
 * Servlet implementation class ModificaFotoAdmin
 */
@WebServlet("/modificafoto")
@MultipartConfig(fileSizeThreshold=1024*1024*2,    // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB

public class ModificaFotoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDAO model;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		model = new ProdottoDAOImpl();
		Prodotto prodotto = null;
		String idProdTemp = "";
		
		idProdTemp= request.getParameter("id");
		
		
			try 
			{
				int id = Integer.parseInt(idProdTemp);
				prodotto = model.getProdottoById(id);
				request.setAttribute("prodotto", prodotto);
				request.getRequestDispatcher("modificaFoto.jsp").forward(request, response);
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch( NumberFormatException e1)
			{
				response.sendError(404);
				e1.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String text = "";
		String srcImg="";
		String idTemp = (String) request.getParameter("id");
		Part foto = request.getPart("newImage");
		if(foto == null || foto.getSubmittedFileName().equals(""))
		{
			srcImg = "default.png";
		}
		else
		{
			srcImg = foto.getSubmittedFileName();
		}
		
		if (idTemp != null)
		{
			int id = Integer.parseInt(idTemp);
		        
		        String appPath = request.getServletContext().getRealPath("");
				String savePath = appPath + File.separator + "imgs"+ File.separator+"prodotti";
				CaricatoreFoto caricatore = new CaricatoreFoto(foto);
				caricatore.caricaFotoInPath(savePath);
				System.out.println(savePath);
				
				try {
					if(model.modificaFoto(srcImg, id))
					{						
						text="Modifica foto riuscita!";
								
					} 
					else
					{
						text="C'è stato qualche errore!";
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
				request.getSession().setAttribute("mexModFoto", text);
				response.sendRedirect(this.getServletContext().getContextPath()+"/modificafoto?id="+idTemp);
	

		}
		else
		{
			response.sendError(404);
		}
	}
}
