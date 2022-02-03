package it.unisa.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.beans.Prodotto;
import it.unisa.model.dao.CategoriaDAO;
import it.unisa.model.dao.CategoriaDAOImpl;
import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;



/**
 * Servlet implementation class ModificaProdottoServlet
 */
@WebServlet("/modifica")
public class ModificaProdottoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private ProdottoDAO model;
    private CategoriaDAO modelCat;
    
    static String SAVE_DIR ="/uploadTemp";
	
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
				request.getRequestDispatcher("modificaProdotto.jsp").forward(request, response);
				
				
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		model = new ProdottoDAOImpl();
		modelCat = new CategoriaDAOImpl();
		String messaggio="";
		String idProdTemp = "";
		
		idProdTemp= request.getParameter("id").trim();
	
		try 
		{
			int id = Integer.parseInt(idProdTemp);
			String nomeProd = request.getParameter("nomeProd");
			String descr = request.getParameter("descriz");
			double prezzo=Double.parseDouble(request.getParameter("prezzoProd"));
			int quantitaDisp = Integer.parseInt(request.getParameter("qtaDisp"));
			int idCategoria= Integer.parseInt(request.getParameter("categoria").trim());
			int iva = Integer.parseInt(request.getParameter("ivaProd"));
			String colore = request.getParameter("colore");
			String dimensione = request.getParameter("dimensione");
			
			Prodotto prod = new Prodotto(); 
			prod.setIdProdotto(id);
			prod.setNomeProdotto(nomeProd);		
			prod.setColoreProdotto(colore);
			prod.setDescrizioneProdotto(descr);		
			prod.setPrezzoProdotto(prezzo);		
			prod.setIVAProdotto(iva);		
			prod.setQuantitDisponibile(quantitaDisp);
			prod.setDimensioneProdotto(dimensione);
			prod.setCategoriaProdotto(modelCat.getCategoriaByKey(idCategoria));
			
			if(model.modificaProdotto(prod))
			{
				messaggio= "Modifica del prodotto riuscita!";
			}
			else
			{
				messaggio="Qualcosa è andato storto!";
			}
			
			request.getSession().setAttribute("mexModifica", messaggio);
			response.sendRedirect(this.getServletContext().getContextPath()+"/modifica?id="+id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch( NumberFormatException e1)
		{
			response.sendError(404);
			e1.printStackTrace();
		}

		
		
		
		
		
	}


}
