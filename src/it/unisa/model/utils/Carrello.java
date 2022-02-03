package it.unisa.model.utils;

import java.util.ArrayList;
import it.unisa.model.beans.DettaglioOrdine;
import it.unisa.model.beans.Prodotto;

public class Carrello
{
	private ArrayList<DettaglioOrdine> prodottiCarrello;
	
	
	public Carrello()
	{
		this.prodottiCarrello = new ArrayList<DettaglioOrdine>();
	}

	public ArrayList<DettaglioOrdine> getProdottiCarrello() 
	{
		return prodottiCarrello;
	}


	public void setProdottiCarrello(ArrayList<DettaglioOrdine> prodottiCarrello) 
	{
		this.prodottiCarrello = prodottiCarrello;
	}
	
	
	
	public void aggiungiProdotto(Prodotto prodotto)
	{

		for(DettaglioOrdine prodOrd : this.prodottiCarrello)
		{
			
				//Verifico se il prodotto è presente già nel carrello 
			
				if(prodOrd.getProdottoAssociato().equals(prodotto) ) 					//Verifico se il prodotto è gia presente nel carrello
				{
					
					prodOrd.setQuantitaAcquistata( prodOrd.getQuantitaAcquistata()+1 );					//Devo aggiornare(di 1) la quantità 
					prodOrd.setSubtotaleDettOrdine(prodOrd.getQuantitaAcquistata()*prodOrd.getPrezzoUnitario());  															//Devo aggiornare anche il subtotale( quantita * prezzo)
					return;
				}
						
		}
			
			//Il prodotto non è presente, devo inserirlo con quantità pari a 1
		
		
			DettaglioOrdine newOrderProd = new DettaglioOrdine();
			newOrderProd.setProdottoAssociato(prodotto);
			newOrderProd.setPrezzoUnitario(prodotto.getPrezzoConIva());
			newOrderProd.setQuantitaAcquistata(1);
			newOrderProd.setSubtotaleDettOrdine(newOrderProd.getPrezzoUnitario()*newOrderProd.getQuantitaAcquistata()); 			//Aggiorno il subtotale
			this.prodottiCarrello.add(newOrderProd);
	}
		
	
	/**
	 * Metodo che elimina un prodotto dal carrello
	 * @param prodotto da eliminare
	 * 
	 */
	public void cancellaProdotto(Prodotto prodotto) 
	{
		for(DettaglioOrdine ordProd : this.prodottiCarrello) 
		{
			
			if(	ordProd.getProdottoAssociato().equals(prodotto))		//Elimino il prodotto dal carrello
			{
				
				prodottiCarrello.remove(ordProd);
				return;
			}
		}
 	}
	

	/**
	 * Aggiorna la quantita del prodotto nel carrello, se l'utente inserisce una quantita pari a 0, il prodotto sarà cancellato dal carrello
	 * @param prodotto da aggiornare con la nuova quantità
	 * @param newQuantita quantità da aggiornare
	 */
	public void modificaQuantitaProdotto(Prodotto prodotto, int newQuantita)
	{
		/* Se l'utente sceglie 0, significa che vuole rimuovere il prodotto */
		if(newQuantita == 0)
		{
			
			this.cancellaProdotto(prodotto);
			
		}
		
		for(DettaglioOrdine ordProd : this.prodottiCarrello) 
		{
			
			if(ordProd.getProdottoAssociato().equals(prodotto))
			{
				
				ordProd.setQuantitaAcquistata(newQuantita);											//modifico la quantita con quella richiesta
				ordProd.setSubtotaleDettOrdine(newQuantita*ordProd.getPrezzoUnitario());			//mi tocca aggiornare il subtotale 
				return;
			}
			
		}	
	}
	
	/**
	 * Metodo che cancella tutti i prodotti dal carrello
	 */
	public void svuotaCarrello()
	{
		
		if(prodottiCarrello.isEmpty())
		{
			
			return;
			
		}
		
		this.prodottiCarrello.removeAll(prodottiCarrello);
		
	}

	
	/*
	 * Metood che calcola il prezzo totale provvisorio del carrello
	 */
	public double calcolaTotaleCarrello()
	{
		double totaleProvvisorio = 0;
		
		for(DettaglioOrdine ordProd : this.prodottiCarrello)
		{
			
			totaleProvvisorio += ordProd.getSubtotaleDettOrdine();
			
		}
		
		return totaleProvvisorio;
	}
	
	/*
	 * Metodo che ritorna il numero di prodotti complessivi presenti nel carrello ( il numero di prodotti nel carrello va in base alla quantità)
	 * 
	 */
	public int calcolaQuantitaProdottiNelCarrello()
	{
		int quantitaProvvisoria=0;
		
		for(DettaglioOrdine ordProd : this.prodottiCarrello)
		{
			
			quantitaProvvisoria+= ordProd.getQuantitaAcquistata();
			
		}
		
		return quantitaProvvisoria;
	}

	

}
