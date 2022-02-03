package it.unisa.model.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.*;

public interface OrdineDAO 
{

	
	boolean insert(Ordine ordine) throws SQLException;
	
	int getLastId() throws SQLException;
	
	ArrayList<Ordine> getOrdine(String email) throws SQLException;
	
	Ordine getOrdineById(int id)  throws SQLException;
	
	int contaOrdini() throws SQLException;
	
	ArrayList<Ordine> getAllOrdini()  throws SQLException;
	
	ArrayList<Ordine> getAllOrdini(String start, String end)  throws SQLException;
}
