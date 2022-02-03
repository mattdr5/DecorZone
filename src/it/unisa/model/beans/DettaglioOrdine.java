package it.unisa.model.beans;


/**
 * Contiene i dati di un singolo dettaglio ordine. Presenta principalmente metodi get e set.
 *  @author Matteo Della Rocca
 *  @author Luca Boffa
 */

public class DettaglioOrdine 
{
	private int idDettOrdine;
	private double prezzoUnitario;
	private double subtotaleDettOrdine;
	private int quantitaAcquistata;
	private double ivaDettaglio;
	private Prodotto prodottoAssociato;
	
	public DettaglioOrdine() 
	{
		// TODO Auto-generated constructor stub
	}


	/* ----------------Metodi get e set -----------------------*/
	
	public int getIdDettOrdine() 
	{
		return idDettOrdine;
	}

	public void setIdDettOrdine(int idDettOrdine) 
	{
		this.idDettOrdine = idDettOrdine;
	}

	public double getPrezzoUnitario() 
	{
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario)
	{
		this.prezzoUnitario = prezzoUnitario;
	}

	public double getSubtotaleDettOrdine() 
	{
		return subtotaleDettOrdine;
	}

	public void setSubtotaleDettOrdine(double subtotaleDettOrdine) 
	{
		this.subtotaleDettOrdine = subtotaleDettOrdine;
	}

	public int getQuantitaAcquistata() 
	{
		return quantitaAcquistata;
	}

	public void setQuantitaAcquistata(int quantitaAcquistata) 
	{
		this.quantitaAcquistata = quantitaAcquistata;
	}

	public Prodotto getProdottoAssociato() 
	{
		return prodottoAssociato;
	}

	public void setProdottoAssociato(Prodotto prodottoAssociato) 
	{
		this.prodottoAssociato = prodottoAssociato;
	}


	public double getIvaDettaglio() {
		return ivaDettaglio;
	}


	public void setIvaDettaglio(int ivaDettaglio) {
		this.ivaDettaglio = ivaDettaglio;
	}
	
	/*------------------Fine metodi get e set-----------------*/
	

}
