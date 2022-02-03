package it.unisa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.unisa.model.beans.Carta;


public class CartaDAOImpl implements CartaDAO {
	
private DataSource ds;
	
	public CartaDAOImpl() 
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
	public boolean inserisciCarta(Carta carta) throws SQLException {
		Connection conn= null;
        PreparedStatement ps = null;
       
       
        String insertSQL = "INSERT INTO prodotto VALUES (?,?,?,? )";
        boolean done= false;
        try
        {
            conn=ds.getConnection();
            conn.setAutoCommit(false);
            ps= conn.prepareStatement(insertSQL);
           
           
               
            ps.setString(1, carta.getNumCarta());
            ps.setString(2, carta.getCvc());
            ps.setString(3, carta.getUser());
            ps.setDouble(4, carta.getSaldo());
           
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
	public Carta getCarta(String numCarta) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String query ="SELECT * FROM carta where numeroCarta=?;";
	
		conn= ds.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, numCarta);
		ResultSet result = ps.executeQuery();
	
		Carta carta = null;
		while(result.next())
		{
			carta= new Carta();
			carta.setNumCarta(result.getString("numeroCarta"));
			carta.setCvc(result.getString("CVC"));
			carta.setUser(result.getString("fk_utente"));		
			carta.setSaldo(result.getDouble("saldo"));
		}
	
		result.close();
		ps.close();
		conn.close();
	
		return carta;
	
	}
	
	public synchronized boolean delete(int numCarta) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		String deleteSQL = "DELETE FROM carta WHERE numeroCarta= ?";

		try 
		{
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, numCarta);



			result = preparedStatement.executeUpdate();
			
		} 
		finally 
		{
			try 
			{
				if (preparedStatement != null)
						preparedStatement.close();
			} finally 
			{
				if (connection != null)
						connection.close();
        }
	}
		
		return (result != 0);
	}
	
	public boolean acquista(Double spesa) throws SQLException
	{		
			Connection conn= null;
			PreparedStatement ps = null;
			
			
			String query ="update carta set saldo = saldo - ?";
			boolean done= false;
			try 
			{
				conn=ds.getConnection();
				conn.setAutoCommit(false);
				ps= conn.prepareStatement(query);
				
				
					
				ps.setDouble(1, spesa );
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
	
	public boolean checkCarta(String numCarta) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String query= "SELECT * FROM carta WHERE numeroCarta=? ";
		boolean trovato = false;
		
		conn = ds.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, numCarta);
		
		ResultSet result = ps.executeQuery();
		
		if(result.next())
		{
			trovato = true;
		}
		
		result.close();
		ps.close();
		conn.close();

		return trovato;
	}
}
