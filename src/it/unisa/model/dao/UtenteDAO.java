package it.unisa.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.Utente;


public interface UtenteDAO {

	boolean checkEmail(String email) throws SQLException;
	
	Utente getById(String email) throws SQLException;

	boolean insert(Utente newUser) throws SQLException;

	Utente getByEmailAndPassword(String email, String password) throws SQLException;
	
	boolean modificaDatiUtente(String email, String nome, String cognome, String numTel) throws SQLException;
	
	boolean modificaPasswordUtente(String email, String password) throws SQLException;

	int contaUtenti() throws SQLException;
	
	ArrayList<Utente >getAllUsers() throws SQLException;
}
