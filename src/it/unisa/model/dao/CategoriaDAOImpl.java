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

public class CategoriaDAOImpl implements CategoriaDAO
{
	
	private DataSource ds;
	private static final String queryGetAllCategorie =" select * from categoria";
	private static final String queryGetCategoriaByKey =" select * from categoria where idCategoria=?";
	
	public CategoriaDAOImpl() 
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
	public ArrayList<Categoria> getAllCategorie() throws SQLException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Categoria> listaCategorie = null;
		
		
		conn= ds.getConnection();
		ps= conn.prepareStatement(queryGetAllCategorie);
		
		ResultSet result = ps.executeQuery();
		
		listaCategorie  = new ArrayList<Categoria>();
		while(result.next())
		{
			Categoria categoria = new Categoria();
			
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			categoria.setSrcImg(result.getString("srcImg"));
			
			listaCategorie.add(categoria);
		}
		
		
		result.close();
		ps.close();
		conn.close();
		
		return listaCategorie;
		
	}

	@Override
	public Categoria getCategoriaByKey(int id) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		Categoria categoria = null;
		
		
		conn = ds.getConnection();
		ps = conn.prepareStatement(queryGetCategoriaByKey);
		ps.setInt(1, id);
		
		
		ResultSet result = ps.executeQuery();
		
		if(result.next())
		{
			categoria = new Categoria();
			
			categoria.setIdCategoria(result.getInt("idCategoria"));
			categoria.setNomeCategoria(result.getString("nomeCategoria"));
			categoria.setSrcImg(result.getString("srcImg"));
			
		}
		
		result.close();
		ps.close();
		conn.close();
		
		return categoria;
	
		
	}


}
