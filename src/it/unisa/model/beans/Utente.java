package it.unisa.model.beans;

import java.util.ArrayList;

/**
 * Contiene i dati di un singolo utente. Presenta principalmente metodi get e set, ed
 * un metodo per verificare se due utenti sono uguali
 * @author Matte Della Rocca
 *
 */
public class Utente 
{
	private String emailUtente;
	private String nomeUtente;
	private String cognomeUtente;
	private String passwordUtente;
	private String numeroTelefonoUtente;
	private boolean ruoloUtente; /* True se è un admin, false se è un utente registrato */
	private ArrayList<Ordine> listaOrdini;
	
	
	public Utente() 
	{
		setListaOrdini(new ArrayList<Ordine>());
	}

	
	
	/* ----------------Metodi get e set---------------------*/
	
	
	public String getEmailUtente() 
	{
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) 
	{
		this.emailUtente = emailUtente;
	}

	public String getNomeUtente() 
	{
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) 
	{
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() 
	{
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) 
	{
		this.cognomeUtente = cognomeUtente;
	}
	

	public String getPasswordUtente() {
		return passwordUtente;
	}



	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}



	public String getNumeroTelefonoUtente() 
	{
		return numeroTelefonoUtente;
	}

	public void setNumeroTelefonoUtente(String numeroTelefonoUtente) 
	{
		this.numeroTelefonoUtente = numeroTelefonoUtente;
	}

	public boolean isRuoloUtente() 
	{
		return ruoloUtente;
	}

	public void setRuoloUtente(boolean ruoloUtente) 
	{
		this.ruoloUtente = ruoloUtente;
	}

	
	public ArrayList<Ordine> getListaOrdini() 
	{
		return listaOrdini;
	}

	public void setListaOrdini(ArrayList<Ordine> listaOrdini) 
	{
		this.listaOrdini = listaOrdini;
	}
	

	
	/*----------------fine metodi get e set--------------------*/
	
	
	/* --------------Metodo equals ------------------------*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (emailUtente == null) {
			if (other.emailUtente != null)
				return false;
		} else if (!emailUtente.equals(other.emailUtente))
			return false;
		return true;
	}




	








	
	/*--------------Fine metodo equals----------------------------*/
	
	
}
