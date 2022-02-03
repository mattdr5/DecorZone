package it.unisa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import it.unisa.model.beans.Categoria;
import it.unisa.model.beans.Prodotto;
import it.unisa.model.utils.CatalogoProdotti;

public class ProdottoDAOImpl implements ProdottoDAO
{
	private DataSource ds;
	
	public ProdottoDAOImpl() 
	{
		Context initCtx;
		try 
		{
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/decorzone");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	@Override
	public CatalogoProdotti getAllProdotti() throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		CatalogoProdotti catalogo = null;
		
		
		String query = "SELECT * FROM decorzone.prodotto\r\n" + 
				"inner join categoria\r\n" + 
				"on prodotto.fk_categoria = categoria.idCategoria;";
		
		
		conn= ds.getConnection();
		ps=conn.prepareStatement(query);
		
		ResultSet result = ps.executeQuery();
		
		catalogo = new CatalogoProdotti();
		while(result.next())
		{
			Prodotto prodotto = new Prodotto();
			Categoria categoria = new Categoria();
			
			prodotto.setIdProdotto(result.getInt("idProdotto"));
			prodotto.setNomeProdotto(result.getString("nomeProdotto"));
			prodotto.setDescrizioneProdotto(result.getString("descrizione"));
			prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			prodotto.setSrcImgProdotto(result.getString("srcImg"));
			prodotto.setQuantitDisponibile(result.getInt("quantit‡Disponibile"));
			prodotto.setColoreProdotto(result.getString("colore"));
			prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
			prodotto.setDimensioneProdotto(result.getString("dimensione"));
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			prodotto.setCategoriaProdotto(categoria);
			
			catalogo.aggiungiProdotto(prodotto);
			
		}
		
		result.close();
		ps.close();
		conn.close();
		
		return catalogo;
		
			
	}





	@Override
	public CatalogoProdotti getAllProdottiByCategoria(int idCategoria) throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		CatalogoProdotti catalogo = null;
		
		String query="SELECT * FROM (decorzone.prodotto\r\n" + 
				"inner join categoria\r\n" + 
				"on prodotto.fk_categoria = categoria.idCategoria)\r\n" + 
				"where idCategoria=?;";
		
		
		conn= ds.getConnection();
		ps=conn.prepareStatement(query);
		ps.setInt(1, idCategoria);
		
		
		ResultSet result = ps.executeQuery();
		
		catalogo = new CatalogoProdotti();
		while(result.next())
		{
			Prodotto prodotto = new Prodotto();
			Categoria categoria = new Categoria();
			
			prodotto.setIdProdotto(result.getInt("idProdotto"));
			prodotto.setNomeProdotto(result.getString("nomeProdotto"));
			prodotto.setDescrizioneProdotto(result.getString("descrizione"));
			prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			prodotto.setQuantitDisponibile(result.getInt("quantit‡Disponibile"));
			prodotto.setSrcImgProdotto(result.getString("srcImg"));
			prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
			prodotto.setColoreProdotto(result.getString("colore"));
			prodotto.setDimensioneProdotto(result.getString("dimensione"));
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			prodotto.setCategoriaProdotto(categoria);
			
			catalogo.aggiungiProdotto(prodotto);
			catalogo.setCategoriaCatalogo(categoria);
			
		}
		
		result.close();
		ps.close();
		conn.close();
		
		return catalogo;
		
			
		
	}





	@Override
	public Prodotto getProdottoById(int id) throws SQLException 
	{
		Connection conn= null;
		PreparedStatement ps= null;
		Prodotto prodotto = null;
		Categoria categoria = null;
		
		String query= "SELECT * FROM (decorzone.prodotto\r\n" +
				"inner join categoria\r\n"+
				"on prodotto.fk_categoria = categoria.idCategoria)\r\n"+
				"where idProdotto=?";
		
	
		conn= ds.getConnection();
		ps= conn.prepareStatement(query);
		ps.setInt(1, id);
			
		ResultSet result = ps.executeQuery();
			
		while(result.next())
		{
			prodotto= new Prodotto();
			categoria = new Categoria();
				
				
			prodotto.setIdProdotto(result.getInt("idProdotto"));
			prodotto.setNomeProdotto(result.getString("nomeProdotto"));
			prodotto.setDescrizioneProdotto(result.getString("descrizione"));
			prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			prodotto.setQuantitDisponibile(result.getInt("quantit‡Disponibile"));
			prodotto.setSrcImgProdotto(result.getString("srcImg"));
			prodotto.setColoreProdotto(result.getString("colore"));
			prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
			prodotto.setDimensioneProdotto(result.getString("dimensione"));
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			prodotto.setCategoriaProdotto(categoria);
			
		
		} 
	
		result.close();
		ps.close();
		conn.close();
		return prodotto;
	}





	@Override
	public ArrayList<Prodotto> getProdottiConsigliati() throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Prodotto> prodottiConsigliati = null;
		
		
		String query = "select * from prodotto where quantit‡Disponibile>=90 limit 3; ";
		
		
		conn= ds.getConnection();
		ps = conn.prepareStatement(query);
		
		ResultSet result = ps.executeQuery();
		
		prodottiConsigliati = new ArrayList<Prodotto>();
		
		while(result.next())
		{
			Prodotto prodotto = new Prodotto();
			
			prodotto.setIdProdotto(result.getInt("idProdotto"));
			prodotto.setNomeProdotto(result.getString("nomeProdotto"));
			prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			prodotto.setSrcImgProdotto(result.getString("srcImg"));
			prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
			prodotto.setPrezzoProdotto(Math.round(prodotto.getPrezzoConIva() * 100.0) / 100.00);
			prodottiConsigliati.add(prodotto);
			
		}
		
		
		
		
		result.close();
		ps.close();
		conn.close();
		
		
		return prodottiConsigliati;
	}
	
	
	public boolean  diminuisciQuantita(int idOrdine) throws SQLException  {
		
		Connection conn= null;
		PreparedStatement ps= null;
		
		boolean flag = false;
		
		String query="UPDATE prodotto \r\n" + 
				"				inner join dettaglio_ordine\r\n" + 
				"				on dettaglio_ordine.fk_prodotto = prodotto.idProdotto\r\n" + 
				"                set prodotto.quantit‡Disponibile = prodotto.quantit‡Disponibile - dettaglio_ordine.qntAcquistata \r\n" + 
				"				where dettaglio_ordine.fk_ordine = "+idOrdine ;
		
		conn= ds.getConnection();
		conn.setAutoCommit(false);
		ps= conn.prepareStatement(query);
		
			if(ps.executeUpdate(query) > 0) 
			{
			flag = true;
			}
		
		conn.commit();
		ps.close();
		conn.close();
		
		return flag;

}





	@Override
	public boolean getDisponibilitaProdotto(int id, int quantit‡Richiesta) throws SQLException 
	{
		Connection conn= null;
		PreparedStatement ps = null;
		boolean disponibile = false;
		String query = "SELECT quantit‡Disponibile FROM decorzone.prodotto where idProdotto=?;";
		
		
		conn=ds.getConnection();
		ps= conn.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		if(result.first())
		{
			int quantitaInDb = result.getInt("quantit‡Disponibile");
			if(quantit‡Richiesta < quantitaInDb)
			{
				disponibile = true;
			}
		}
		
		
		
		result.close();
		ps.close();
		conn.close();
		
		return disponibile;
	}





	@Override
	public CatalogoProdotti cercaProdotto(String testo) throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		CatalogoProdotti catalogo = null;
		String query = "SELECT * FROM prodotto inner join categoria on prodotto.fk_categoria = categoria.idCategoria where nomeProdotto like ?";
	
		
		conn = ds.getConnection();
		ps = conn.prepareStatement(query);
		
		if(testo.equals("tutti i prodotti"))
		{
			ps.setString(1, "%");
		}
		else
		{
			ps.setString(1, "%"+ testo +"%");
		}
		
		ResultSet result = ps.executeQuery();
		catalogo= new CatalogoProdotti();
		while(result.next())
		{
			Prodotto prodotto= new Prodotto();
			Categoria categoria = new Categoria();
			prodotto.setIdProdotto(result.getInt("idProdotto"));
			prodotto.setNomeProdotto(result.getString("nomeProdotto"));
			prodotto.setDescrizioneProdotto(result.getString("descrizione"));
			prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			prodotto.setQuantitDisponibile(result.getInt("quantit‡Disponibile"));
			prodotto.setSrcImgProdotto(result.getString("srcImg"));
			prodotto.setColoreProdotto(result.getString("colore"));
			prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
			prodotto.setDimensioneProdotto(result.getString("dimensione"));
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			prodotto.setCategoriaProdotto(categoria);
			
			catalogo.aggiungiProdotto(prodotto);
		}
		
		
		result.close();
		ps.close();
		conn.close();
		
		return catalogo;
		
		
		
		

	}





	@Override
	public int contaProdotti() throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		int numProd = 0;
		
		String query = "select count(idProdotto) as 'num_prodotti' from prodotto;";
		
		conn = ds.getConnection();
		ps = conn.prepareStatement(query);
		
		ResultSet result = ps.executeQuery();
		
		if(result.next())
		{
			numProd  = result.getInt("num_prodotti");
		}
		
		result.close();
		ps.close();
		conn.close();
	
		
		return numProd;
	}





	@Override
	public boolean inserisciProdotto(Prodotto prodotto) throws SQLException {
		Connection conn= null;
        PreparedStatement ps = null;
       
       
        String insertSQL = "INSERT INTO prodotto VALUES (?,?,?,?,?,?,?,?,?,?)";
        boolean done= false;
        try
        {
            conn=ds.getConnection();
            conn.setAutoCommit(false);
            ps= conn.prepareStatement(insertSQL);
           
           
               
            ps.setInt(1, prodotto.getIdProdotto());
            ps.setInt(2, prodotto.getCategoriaProdotto().getIdCategoria());
            ps.setString(3, prodotto.getNomeProdotto());
            ps.setString(4, prodotto.getDescrizioneProdotto());
            ps.setDouble(5, prodotto.getPrezzoProdotto());
            ps.setString(6, prodotto.getSrcImgProdotto());
            ps.setInt(7, prodotto.getQuantitaDisponibile());
            ps.setString(8,prodotto.getColoreProdotto());
            ps.setString(9, prodotto.getDimensioneProdotto());
            ps.setDouble(10, prodotto.getIVAProdotto());
            if(ps.executeUpdate() == 1)
            {
                done=true;
            }
           
            conn.commit();
        }
        finally
        {
            try
            {
                if (ps != null)
                {
                    ps.close();
                }
            }
            finally
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
        }
       
        return done;
    }





	@Override
	public CatalogoProdotti getAllProdotti(String sort) throws SQLException {
		
		 Connection conn = null;
	        PreparedStatement ps = null;
	        CatalogoProdotti catalogo = null;
	       
	       
	        String query = "SELECT * FROM decorzone.prodotto\r\n" +
	                "inner join categoria\r\n" +
	                "on (prodotto.fk_categoria = categoria.idCategoria) ";
	       
	        if (sort != null && !sort.equals("")) {
	            query += " ORDER BY " + sort;
	        }
	       
	        conn= ds.getConnection();
	        ps=conn.prepareStatement(query);
	       
	        ResultSet result = ps.executeQuery();
	       
	        catalogo = new CatalogoProdotti();
	        while(result.next())
	        {
	            Prodotto prodotto = new Prodotto();
	            Categoria categoria = new Categoria();
	           
	            prodotto.setIdProdotto(result.getInt("idProdotto"));
	            prodotto.setNomeProdotto(result.getString("nomeProdotto"));
	            prodotto.setDescrizioneProdotto(result.getString("descrizione"));
	            prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
	            prodotto.setSrcImgProdotto(result.getString("srcImg"));
	            prodotto.setColoreProdotto(result.getString("colore"));
	            prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
	            prodotto.setDimensioneProdotto(result.getString("dimensione"));
	            prodotto.setQuantitDisponibile(result.getInt("quantit‡Disponibile"));
	            categoria.setIdCategoria(result.getInt("idCategoria"));
	            categoria.setNomeCategoria(result.getString("nomeCategoria"));
	           
	            prodotto.setCategoriaProdotto(categoria);
	           
	            catalogo.aggiungiProdotto(prodotto);
	           
	        }
	       
	        result.close();
	        ps.close();
	        conn.close();
	       
	        return catalogo;

	}





	@Override
	public boolean cancellaProdotto(int idProdotto) throws SQLException
	{
		Connection conn= null;
		PreparedStatement ps = null;
		
		
		String query ="update prodotto set quantit‡Disponibile=0 where idProdotto=?";
		boolean done= false;
		try 
		{
			conn=ds.getConnection();
			conn.setAutoCommit(false);
			ps= conn.prepareStatement(query);
			
			
				
			ps.setInt(1, idProdotto);
			if(ps.executeUpdate() == 1)
			{
				done=true;
			}
			
			conn.commit();
		} 
		finally
		{
			try 
			{
				if (ps != null)
				{
					ps.close();
				}
			} 
			finally
			{
				if (conn != null)
				{
					conn.close();
				}
			}
		}
		
		
		return done;
		
	}





	@Override
	public boolean modificaProdotto(Prodotto prod) throws SQLException 
	{
		Connection conn= null;
        PreparedStatement ps = null;
       
       
        String modSQL = "update prodotto set fk_categoria=?, nomeProdotto=?,descrizione=?, prezzoProdotto=?, quantit‡Disponibile=?, colore=?, \r\n" + 
        		"dimensione=?, ivaProdotto=? where idProdotto=?";
        boolean done= false;
        try
        {
            conn=ds.getConnection();
            conn.setAutoCommit(false);
            ps= conn.prepareStatement(modSQL);
           
           
               
            ps.setInt(1, prod.getCategoriaProdotto().getIdCategoria());
            ps.setString(2, prod.getNomeProdotto());
            ps.setString(3, prod.getDescrizioneProdotto());
            ps.setDouble(4, prod.getPrezzoProdotto());
            ps.setInt(5, prod.getQuantitaDisponibile());
            ps.setString(6,prod.getColoreProdotto());
            ps.setString(7, prod.getDimensioneProdotto());
            ps.setDouble(8, prod.getIVAProdotto());
            ps.setInt(9, prod.getIdProdotto());
            if(ps.executeUpdate() == 1)
            {
                done=true;
            }
           
            conn.commit();
        }
        finally
        {
            try
            {
                if (ps != null)
                {
                    ps.close();
                }
            }
            finally
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
        }
       
        return done;
	}





	@Override
	public boolean modificaFoto(String srcImg, int id) throws SQLException {
		Connection conn= null;
        PreparedStatement ps = null;
       
       
        String modSQL = "update prodotto set srcImg=? where idProdotto=?";
        boolean done= false;
        try
        {
            conn=ds.getConnection();
            conn.setAutoCommit(false);
            ps= conn.prepareStatement(modSQL);
           
           
               
            ps.setString(1, srcImg);
            ps.setInt(2, id);
            
            if(ps.executeUpdate() == 1)
            {
                done=true;
            }
           
            conn.commit();
        }
        finally
        {
            try
            {
                if (ps != null)
                {
                    ps.close();
                }
            }
            finally
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
        }
       
        return done;
	}





	@Override
	public CatalogoProdotti getAllProdottiByCategoria(int idCategoria, String order) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		CatalogoProdotti catalogo = null;
		
		String query="SELECT * FROM (decorzone.prodotto\r\n" + 
				"inner join categoria\r\n" + 
				"on prodotto.fk_categoria = categoria.idCategoria)\r\n" + 
				"where idCategoria=? order by ";
		
		if(order!= null && !order.equals(""))
		{
			
				query+= order;
			
		}
		conn= ds.getConnection();
		ps=conn.prepareStatement(query);
		ps.setInt(1, idCategoria);
		
		
		ResultSet result = ps.executeQuery();
		
		catalogo = new CatalogoProdotti();
		while(result.next())
		{
			Prodotto prodotto = new Prodotto();
			Categoria categoria = new Categoria();
			
			prodotto.setIdProdotto(result.getInt("idProdotto"));
			prodotto.setNomeProdotto(result.getString("nomeProdotto"));
			prodotto.setDescrizioneProdotto(result.getString("descrizione"));
			prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			prodotto.setQuantitDisponibile(result.getInt("quantit‡Disponibile"));
			prodotto.setSrcImgProdotto(result.getString("srcImg"));
			prodotto.setIVAProdotto(result.getInt("ivaProdotto"));
			prodotto.setColoreProdotto(result.getString("colore"));
			prodotto.setDimensioneProdotto(result.getString("dimensione"));
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			prodotto.setCategoriaProdotto(categoria);
			prodotto.setPrezzoProdotto(Math.round(prodotto.getPrezzoConIva() * 100.0) / 100.00);
			catalogo.aggiungiProdotto(prodotto);
			catalogo.setCategoriaCatalogo(categoria);
			
		}
		
		result.close();
		ps.close();
		conn.close();
		
		return catalogo;
		
			
		
	}
}
