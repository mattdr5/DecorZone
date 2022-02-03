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
import it.unisa.model.dao.CategoriaDAO;
import it.unisa.model.dao.CategoriaDAOImpl;
import it.unisa.model.dao.ProdottoDAO;
import it.unisa.model.dao.ProdottoDAOImpl;
import it.unisa.model.helper.CaricatoreFoto;

/**
 * Servlet implementation class ModificaProdottoServlet
 */
@WebServlet("/aggiungiprodotto")
@MultipartConfig(fileSizeThreshold=1024*1024*2,    // 2MB
					maxFileSize=1024*1024*10,      // 10MB
					maxRequestSize=1024*1024*50)   // 50MB


public class InserisciProdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    private ProdottoDAO model;
    private CategoriaDAO modelCat;
    static String SAVE_DIR ="/imgs/prodotti";
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		model = new ProdottoDAOImpl();
		modelCat = new CategoriaDAOImpl();
		String messaggio="";
		
		
		String nomeProd = request.getParameter("nomeProd");
		String descr = request.getParameter("descriz");
		double prezzo=Double.parseDouble(request.getParameter("prezzoProd"));
		int quantitaDisp = Integer.parseInt(request.getParameter("qtaDisp"));
		Part foto = request.getPart("photo");
		String srcFoto = "";
		int idCategoria= Integer.parseInt(request.getParameter("categoria").trim());
		int iva = Integer.parseInt(request.getParameter("ivaProd"));
		String colore = request.getParameter("colore");
		String dimensione = request.getParameter("dimensione");
		
		Prodotto prod = new Prodotto();
		
		srcFoto = foto.getSubmittedFileName();
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + "imgs"+ File.separator+"prodotti";
		CaricatoreFoto caricatore = new CaricatoreFoto(foto);
		caricatore.caricaFotoInPath(savePath);
		
		try 
		{
		
			prod.setNomeProdotto(nomeProd);		
			prod.setColoreProdotto(colore);
			prod.setDescrizioneProdotto(descr);		
			prod.setPrezzoProdotto(prezzo);		
			prod.setIVAProdotto(iva);		
			prod.setQuantitDisponibile(quantitaDisp);
			prod.setSrcImgProdotto(srcFoto);
			prod.setDimensioneProdotto(dimensione);
			prod.setCategoriaProdotto(modelCat.getCategoriaByKey(idCategoria));
			
			if(model.inserisciProdotto(prod))
			{
				messaggio= "Aggiunta del prodotto riuscita!";
			}
			else
			{
				messaggio="Qualcosa è andato storto!";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.getSession().setAttribute("mexAggiunta", messaggio);
		response.sendRedirect(this.getServletContext().getContextPath()+"/dashboard");
	
	}


}