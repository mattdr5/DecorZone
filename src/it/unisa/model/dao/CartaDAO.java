package it.unisa.model.dao;

import java.sql.SQLException;

import it.unisa.model.beans.Carta;

public interface CartaDAO {

	boolean inserisciCarta(Carta carta) throws SQLException;

	Carta getCarta(String numCarta) throws SQLException;
	
	boolean delete(int numCarta) throws SQLException;
	
	 boolean checkCarta(String numCarta) throws SQLException;
	
	 public boolean acquista(Double spesa) throws SQLException;
}
