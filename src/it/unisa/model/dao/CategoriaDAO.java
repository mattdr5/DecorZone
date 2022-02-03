package it.unisa.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.Categoria;

public interface CategoriaDAO 
{
	ArrayList<Categoria> getAllCategorie() throws SQLException;
	
	Categoria getCategoriaByKey(int id) throws SQLException;
	
}
