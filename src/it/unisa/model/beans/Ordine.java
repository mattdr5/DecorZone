package it.unisa.model.beans;

import java.util.ArrayList;

/**
 * Contiene i dati di un singolo dettaglio ordine. Presenta principalmente metodi get e set.
 * @author Matteo Della Rocca
 * @author Luca Boffa
 */
public class Ordine 
{

	private int idOrdine;
	private double totaleOrdine;
	private double quantitaTotaleOrdinata;
	private String dataOrdine;
	private String indirizzoSpedizione;
	private String email;
	private ArrayList<DettaglioOrdine> dettagliOrdine;
	
	public Ordine() 
	{
		this.setDettagliOrdine(new ArrayList<DettaglioOrdine>());
	}

	
	/* ----------------- Metodi get e set ---------------*/
	
	public int getIdOrdine() 
	{
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) 
	{
		this.idOrdine = idOrdine;
	}

	public double getTotaleOrdine() 
	{
		return totaleOrdine;
	}

	public void setTotaleOrdine(double totaleOrdine) 
	{
		this.totaleOrdine = totaleOrdine;
	}

	public double getQuantitaTotaleOrdinata() 
	{
		return quantitaTotaleOrdinata;
	}

	public void setQuantitaTotaleOrdinata(double quantitaTotaleOrdinata) 
	{
		this.quantitaTotaleOrdinata = quantitaTotaleOrdinata;
	}

	public String getDataOrdine() 
	{
		return dataOrdine;
	}

	public void setDataOrdine(String dataOrdine) 
	{
		this.dataOrdine = dataOrdine;
	}

	public String getIndirizzoSpedizione() 
	{
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) 
	{
		this.indirizzoSpedizione = indirizzoSpedizione;
	}


	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public ArrayList<DettaglioOrdine> getDettagliOrdine() 
	{
		return dettagliOrdine;
	}


	
	public void setDettagliOrdine(ArrayList<DettaglioOrdine> dettagliOrdine) 
	{
		this.dettagliOrdine = dettagliOrdine;
	}
	
	/* ----------------Fine metodi get e set ----------------*/
	
	public double ivaOrdine(int iva)
	{
		return (this.totaleOrdine*iva)/100;
	}
}
