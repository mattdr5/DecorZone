package it.unisa.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.Prodotto;
import it.unisa.model.utils.CatalogoProdotti;

public interface ProdottoDAO 
{

	CatalogoProdotti getAllProdotti() throws SQLException;
	
	CatalogoProdotti getAllProdotti(String sort) throws SQLException;
	
	CatalogoProdotti getAllProdottiByCategoria(int idCategoria) throws SQLException;
	CatalogoProdotti getAllProdottiByCategoria(int idCategoria, String order) throws SQLException;
	
	Prodotto getProdottoById(int id) throws SQLException;
	
	
	ArrayList<Prodotto> getProdottiConsigliati() throws SQLException;
	
	boolean  diminuisciQuantita(int idOrdine) throws SQLException;
	
	boolean getDisponibilitaProdotto(int id, int quantitaRichiesta) throws SQLException;
	
	CatalogoProdotti cercaProdotto(String testo) throws SQLException;
	
	boolean inserisciProdotto(Prodotto prodotto) throws SQLException;
	
	int contaProdotti() throws SQLException;

	boolean cancellaProdotto(int idProdotto) throws SQLException;

	boolean modificaProdotto(Prodotto prod) throws SQLException;
	
	boolean modificaFoto(String srcImg, int id) throws SQLException;
}
