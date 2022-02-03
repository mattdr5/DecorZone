package it.unisa.model.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.DettaglioOrdine;

public interface DettaglioOrdineDAO {

boolean insert(int idOrdine, DettaglioOrdine ordProd) throws SQLException;
	
	int getLastId() throws SQLException;
	
	ArrayList<DettaglioOrdine> getOrdineProdotti (int idOrdine)  throws SQLException;
	
}








