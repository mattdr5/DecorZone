package it.unisa.model.dao;
import it.unisa.model.beans.DettaglioOrdine;
import it.unisa.model.beans.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class DettaglioOrdineDAOImpl  implements DettaglioOrdineDAO{
	
	
	private CategoriaDAO modelCat = new CategoriaDAOImpl();

	private static DataSource ds;
    static 
    {
        try 
        {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

 

            ds = (DataSource) envCtx.lookup("jdbc/decorzone");

 

        } 
        catch (NamingException e) 
        {
            System.out.println("Error:" + e.getMessage());
        }
	
    }
    
    public boolean insert(int idOrdine, DettaglioOrdine ordProd) throws SQLException
    {
    	
        Connection conn= null;
        PreparedStatement ps = null;
       
        
        String insertSQL = "INSERT INTO dettaglio_ordine(idDettaglioOrdine, prezzoUnitario, subTotale, fk_prodotto, fk_ordine, qntAcquistata , iva) VALUES (?, ?, ?, ? , ? , ?, ?)";
        boolean done= false;
        
        
        conn=ds.getConnection();
        conn.setAutoCommit(false);
        ps= conn.prepareStatement(insertSQL);
           
           
        int last = getLastId();  
               
        ps.setInt(1, last); //id ordine
        ps.setDouble(2, ordProd.getPrezzoUnitario()); //
        ps.setDouble(3, ordProd.getSubtotaleDettOrdine());
        ps.setInt(4, ordProd.getProdottoAssociato().getIdProdotto());
        ps.setInt(5, idOrdine);
        ps.setInt(6, ordProd.getQuantitaAcquistata());
        ps.setDouble(7, ordProd.getProdottoAssociato().getIVAProdotto());
       
        ps.executeUpdate();
           
        conn.commit();    
        done=true;
        
       
       
         ps.close();
         conn.close();
          
        return done;
    }
        
    
    public int getLastId() throws SQLException 
    {
    	
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        int result = 0;

 

        String lastIdSQL = "(SELECT COALESCE(MAX(idDettaglioOrdine), 0) + 1 as 'last_id' FROM dettaglio_ordine as t1)";

 
        connection = ds.getConnection();
        preparedStatement = connection.prepareStatement(lastIdSQL);

 

        ResultSet rs = preparedStatement.executeQuery();
            
        if(rs.next()) 
        {
             result = rs.getInt("last_id");    
        }
            
      
        rs.close();
        preparedStatement.close();
        connection.close();
              
        return result;
    }

    public ArrayList<DettaglioOrdine> getOrdineProdotti (int idOrdine)  throws SQLException
	 {
		 Connection connection = null;
	     PreparedStatement preparedStatement = null;
		 
		 ArrayList<DettaglioOrdine> ordineProdotti = null;
		 
		 
	        String selectSQL = "SELECT *\r\n" + 
	        		"FROM dettaglio_ordine INNER JOIN prodotto\r\n" + 
	        		"ON fk_prodotto = idProdotto\r\n" + 
	        		"where fk_ordine = ? ";

	
	        try {
	        	
	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setInt(1, idOrdine);

	 

	            ResultSet rs = preparedStatement.executeQuery();

	 
	            ordineProdotti = new ArrayList<DettaglioOrdine>();
	            while (rs.next()) {
	            	DettaglioOrdine bean = new DettaglioOrdine();
	                Prodotto nuovo = new Prodotto();
	 
	                nuovo.setIdProdotto(rs.getInt("idProdotto"));
	                nuovo.setNomeProdotto(rs.getString("nomeProdotto"));
	                nuovo.setPrezzoProdotto(rs.getDouble("prezzoProdotto"));
	                nuovo.setQuantitDisponibile(rs.getInt("quantit‡Disponibile"));
	                nuovo.setDescrizioneProdotto(rs.getString("descrizione"));
	                nuovo.setCategoriaProdotto(modelCat.getCategoriaByKey(rs.getInt("fk_categoria")));
	                nuovo.setColoreProdotto(rs.getString("colore"));
	                nuovo.setIVAProdotto(rs.getInt("ivaProdotto"));
	                nuovo.setDimensioneProdotto(rs.getString("dimensione"));
	               
	                nuovo.setSrcImgProdotto(rs.getString("srcImg"));
	                
	                bean.setIdDettOrdine(rs.getInt("idDettaglioOrdine"));
	                bean.setQuantitaAcquistata(rs.getInt("qntAcquistata"));
	                bean.setPrezzoUnitario(rs.getDouble("prezzoUnitario"));
	                bean.setSubtotaleDettOrdine(rs.getDouble("subTotale"));
	                bean.setIvaDettaglio(rs.getInt("iva"));
	                bean.setProdottoAssociato(nuovo);
	               
	               ordineProdotti.add(bean);
	            }

	            rs.close();
	        } 
	        finally 
	            {
	            try 
	            {
	                if (preparedStatement != null)
	                    preparedStatement.close();
	            } 
	            finally 
	                {
	                if (connection != null)
	                    connection.close();
	                }
	            }
	        return ordineProdotti;
		}
    
    
}
