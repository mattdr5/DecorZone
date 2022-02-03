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
import it.unisa.model.beans.Utente;

public class UtenteDAOImpl implements UtenteDAO
{
	private  DataSource ds;
	
	public UtenteDAOImpl() 
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

	@Override
	public boolean checkEmail(String email) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String query= "SELECT * FROM utente WHERE email=? ";
		boolean trovato = false;
		
		conn = ds.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		
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

	@Override
	public Utente getById(String email) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String query ="SELECT * FROM utente where email=?;";
	
		conn= ds.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		ResultSet result = ps.executeQuery();
	
		Utente utente = null;
		while(result.next())
		{
			utente= new Utente();
			utente.setEmailUtente(result.getString("email"));
			utente.setNomeUtente(result.getString("nome"));
			utente.setCognomeUtente(result.getString("cognome"));
			utente.setPasswordUtente(result.getString("password"));
			utente.setNumeroTelefonoUtente(result.getString("numeroDiTelefono"));
			if(result.getInt("ruolo") == 1)
			{
				utente.setRuoloUtente(true);
			}
			else
			{
				utente.setRuoloUtente(false);
			}
					
	}
	
		result.close();
		ps.close();
		conn.close();
	
		return utente;
	
	}


	@Override
	public boolean insert(Utente newUser) throws SQLException 
	{
		Connection conn= null;
		PreparedStatement ps = null;
		boolean success = false;
		
		String query = "insert into utente values(?,?,?,?,?,?);";
		
		conn= ds.getConnection();
		conn.setAutoCommit(false);
		
		ps = conn.prepareStatement(query);
		ps.setString(1, newUser.getEmailUtente());
		ps.setString(2, newUser.getNomeUtente());
		ps.setString(3, newUser.getCognomeUtente());
		ps.setString(4, newUser.getPasswordUtente());
		ps.setString(5, newUser.getNumeroTelefonoUtente());
		ps.setBoolean(6, newUser.isRuoloUtente());
		
		ps.execute();
		conn.commit();
		
		success=true;
		
		
		ps.close();
		conn.close();
		
		return success;
	}

	@Override
	public Utente getByEmailAndPassword(String email, String password) throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		Utente utente = null;
		
		System.out.println("Mi è arrivato " +password);
		String query = "SELECT * FROM utente where email=? and password=?";
		
		conn= ds.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet result = ps.executeQuery();
		
		if(result.first())
		{
			utente = new Utente();
			utente.setNomeUtente(result.getString("nome"));
			utente.setCognomeUtente(result.getString("cognome"));
			utente.setEmailUtente(result.getString("email"));
			utente.setNumeroTelefonoUtente(result.getString("numeroDiTelefono"));
			
			if(result.getInt("ruolo") == 1)
			{
				utente.setRuoloUtente(true);
			}
			else
			{
				utente.setRuoloUtente(false);
			}
			
			
		}
		
		
		result.close();
		ps.close();
		conn.close();
		
		
		return utente;

	}

	@Override
	public boolean modificaDatiUtente(String email, String nome, String cognome, String numTel) throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "update utente set nome=?, cognome=?, numeroDiTelefono=? \n" + 
				"where email=?";
		boolean done= false;
		
		
		conn= ds.getConnection();
		ps= conn.prepareStatement(query);
		conn.setAutoCommit(false);
		ps.setString(1, nome);
		ps.setString(2, cognome);
		ps.setString(3, numTel);
		ps.setString(4, email);
		
		if(ps.executeUpdate() > 0)
		{
			done = true;
		}
		
		conn.commit();
		
		
		ps.close();
		conn.close();	
		
		return done;
	}

	@Override
	public boolean modificaPasswordUtente(String email, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "update utente set password=? where email=?";
		boolean done= false;
		
		
		conn= ds.getConnection();
		ps= conn.prepareStatement(query);
		conn.setAutoCommit(false);
		ps.setString(1, password);
		ps.setString(2, email);
	
		
		if(ps.executeUpdate() > 0)
		{
			done = true;
		}
		
		conn.commit();
		
		
		ps.close();
		conn.close();	
		
		return done;
	}

	@Override
	public int contaUtenti() throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		int numUtenti = 0;
		
		String query = "select count(email) as 'num_utenti' from utente where ruolo=0;";
		
		conn = ds.getConnection();
		ps = conn.prepareStatement(query);
		
		ResultSet result = ps.executeQuery();
		
		if(result.next())
		{
			numUtenti  = result.getInt("num_utenti");
		}
		
		result.close();
		ps.close();
		conn.close();
	
		
		return numUtenti;// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Utente> getAllUsers() throws SQLException 
	{
		   Connection conn = null;
	        PreparedStatement ps = null;
	        ArrayList<Utente> listaUtenti= null;
	       
	       
	        String query = "SELECT * from utente where ruolo=0;";
	       
	        conn=ds.getConnection();
	        ps = conn.prepareStatement(query);
	       
	        ResultSet result = ps.executeQuery();
	       
	        listaUtenti = new ArrayList<Utente>();
	        while(result.next())
	        {
	           
	            Utente user = new Utente();
	           
	            user.setEmailUtente(result.getString("email"));
	            user.setNomeUtente(result.getString("nome"));
	            user.setCognomeUtente(result.getNString("cognome"));
	           
	           
	           
	            listaUtenti.add(user);
	           
	           
	        }
	       
	        result.close();
	        ps.close();
	        conn.close();
	       
	   
	        return listaUtenti;
	}


}
