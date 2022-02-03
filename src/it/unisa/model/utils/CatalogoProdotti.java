package it.unisa.model.utils;

import java.util.ArrayList;

import it.unisa.model.beans.Categoria;
import it.unisa.model.beans.Prodotto;

public class CatalogoProdotti 
{
	
	private ArrayList<Prodotto> catalogo;
	private Categoria categoriaCatalogo;
	
	
	public CatalogoProdotti() 
	{
		this.catalogo = new ArrayList<Prodotto>();
	}
	
	
	public void aggiungiProdotto(Prodotto prod)
	{
		if(this.catalogo.contains(prod))
		{
			return;
		}
		else
		{
			this.catalogo.add(prod);
		}
	}
	
	
	public ArrayList<Prodotto> getCatalogo() 
	{
		return catalogo;
	}
	
	public void setCatalogo(ArrayList<Prodotto> catalogo) 
	{
		this.catalogo = catalogo;
	}


	public Categoria getCategoriaCatalogo() {
		return categoriaCatalogo;
	}


	public void setCategoriaCatalogo(Categoria categoriaCatalogo) {
		this.categoriaCatalogo = categoriaCatalogo;
	}
		

}
