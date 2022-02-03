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


import it.unisa.model.beans.Ordine;
import it.unisa.model.beans.DettaglioOrdine;

public class OrdineDAOImpl implements OrdineDAO {
	

	private static DataSource ds;
	private  DettaglioOrdineDAO model = new DettaglioOrdineDAOImpl();
	private ProdottoDAO modelProd = new ProdottoDAOImpl();
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

	
	public boolean insert(Ordine ordine) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean done = false;
		String query = "insert into ordine values ( ?, ? , ?, ? ,? , ?);";
		
		
		conn= ds.getConnection();
		conn.setAutoCommit(false);
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, ordine.getIdOrdine());
		ps.setDouble(2, ordine.getTotaleOrdine());
		ps.setString(3, ordine.getDataOrdine());
		ps.setDouble(4, ordine.getQuantitaTotaleOrdinata());
		ps.setString(5, ordine.getIndirizzoSpedizione());
		ps.setString(6, ordine.getEmail());
		
		
		ps.executeUpdate();
		conn.commit();
	
		for(DettaglioOrdine ordProd : ordine.getDettagliOrdine())
		{
			
			model.insert(ordine.getIdOrdine(), ordProd);
			
		}
	
			
		if(modelProd.diminuisciQuantita(ordine.getIdOrdine()))
		{
			done= true;
		}
	
	
		
		ps.close();
		conn.close();
		
		
		return done;
		
	}


	public int getLastId() throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		int lastId=0;
		
		String query=" (SELECT COALESCE(MAX(idOrdine), 0) + 1 as 'last_id' FROM ordine as t1)";
		

		conn= ds.getConnection();
		ps = conn.prepareStatement(query);
			
			
		ResultSet result = ps.executeQuery();
			
		if(result.next())
		{
			lastId = result.getInt("last_id");
		}			
			

		result.close();
		ps.close();
		conn.close();
			
		return lastId;
		
	}
	
	 public ArrayList<Ordine> getOrdine(String email)  throws SQLException
	 {
		 Connection connection = null;
	     PreparedStatement preparedStatement = null;
		 
		 ArrayList<Ordine> ordini = null;

		 
		 

	        String selectSQL = "SELECT * FROM ordine where fk_utente =?";

	
	        try {
	        	
	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setString(1, email);

	 

	            ResultSet rs = preparedStatement.executeQuery();

	 
	            ordini = new ArrayList<Ordine>();
	            while (rs.next()) {
	                Ordine bean = new Ordine();

	 

	                bean.setIdOrdine(rs.getInt("idOrdine"));
	                bean.setTotaleOrdine(rs.getDouble("totaleOrdine"));
	                bean.setDataOrdine(rs.getString("dataOrdine"));
	                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
	                bean.setQuantitaTotaleOrdinata(rs.getInt("qntTotale"));
	                bean.setEmail(rs.getString("fk_utente"));
	               
	               ordini.add(bean);
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
	        
	        return ordini;
		}
	 
	 public Ordine getOrdineById(int id)  throws SQLException
	 {
		 Connection connection = null;
	     PreparedStatement preparedStatement = null;

		 Ordine ordine = null;



	        String selectSQL = "SELECT * FROM ordine where idOrdine =?";


	        try {

	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setInt(1, id);



	            ResultSet rs = preparedStatement.executeQuery();


	            ordine =  new Ordine();
	            while (rs.next()) {



	                ordine.setIdOrdine(rs.getInt("idOrdine"));
	                ordine.setTotaleOrdine(rs.getDouble("totaleOrdine"));
	                ordine.setDataOrdine(rs.getString("dataOrdine"));
	                ordine.setQuantitaTotaleOrdinata(rs.getInt("qntTotale"));
	                ordine.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
					ordine.setEmail(rs.getString("fk_utente"));
	            }


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
	        return ordine;
		}


	 public int contaOrdini() throws SQLException 
		{
			Connection conn = null;
			PreparedStatement ps = null;
			int numOrdini = 0;
			
			String query = "select count(idOrdine) as 'num_ordini' from ordine;";
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(query);
			
			ResultSet result = ps.executeQuery();
			
			if(result.next())
			{
				numOrdini  = result.getInt("num_ordini");
			}
			
			result.close();
			ps.close();
			conn.close();
		
			
			return numOrdini;
		}
	 
	 public ArrayList<Ordine> getAllOrdini()  throws SQLException
	 {
		 Connection connection = null;
	     PreparedStatement preparedStatement = null;
		 
		 ArrayList<Ordine> ordini = null;

		 
		 

	        String selectSQL = "SELECT * FROM ordine";

	
	        try {
	        	
	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	        
	            ResultSet rs = preparedStatement.executeQuery();

	 
	            ordini = new ArrayList<Ordine>();
	            while (rs.next()) {
	                Ordine bean = new Ordine();

	 
	                bean.setIdOrdine(rs.getInt("idOrdine"));
	                bean.setTotaleOrdine(rs.getDouble("totaleOrdine"));
	                bean.setDataOrdine(rs.getString("dataOrdine"));
	                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
	                bean.setQuantitaTotaleOrdinata(rs.getInt("qntTotale"));
	                bean.setEmail(rs.getString("fk_utente"));
	               
	               ordini.add(bean);
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
	        
	        return ordini;
		}
	 
	 
	 public ArrayList<Ordine> getAllOrdini(String start, String end)  throws SQLException
	 {
		 Connection connection = null;
	     PreparedStatement preparedStatement = null;
		 
		 ArrayList<Ordine> ordini = null;

		 
		 

	        String selectSQL = "SELECT * FROM ordine WHERE dataOrdine between ? and  ? ;";

	
	        try {
	        	
	            connection = ds.getConnection();
	            preparedStatement = connection.prepareStatement(selectSQL);
	            preparedStatement.setString(1, start);
	            preparedStatement.setString(2, end);

	 

	            ResultSet rs = preparedStatement.executeQuery();

	 
	            ordini = new ArrayList<Ordine>();
	            while (rs.next()) {
	                Ordine bean = new Ordine();

	 

	                bean.setIdOrdine(rs.getInt("idOrdine"));
	                bean.setTotaleOrdine(rs.getDouble("totaleOrdine"));
	                bean.setDataOrdine(rs.getString("dataOrdine"));
	                bean.setIndirizzoSpedizione(rs.getString("indirizzoSpedizione"));
	                bean.setQuantitaTotaleOrdinata(rs.getInt("qntTotale"));
	                bean.setEmail(rs.getString("fk_utente"));
	               
	               ordini.add(bean);
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
	        
	        return ordini;
		}
}
