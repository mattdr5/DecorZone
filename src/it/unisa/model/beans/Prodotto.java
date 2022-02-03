package it.unisa.model.beans;

/**
 *  Contiene i dati di un singolo prodotto. Presenta principalmente metodi get e set,
 *  ed un metodo per verificare quando due prodotti sono uguali 
 * @author Matteo Della Rocca
 * @author Luca Boffa
 *
 */
public class Prodotto 
{
	
	private int idProdotto;
	private String nomeProdotto;
	private int quantitaDisponibile;
	private double prezzoProdotto;
	private String descrizioneProdotto;
	private int IVAProdotto;
	private String dimensioneProdotto;
	private String coloreProdotto;
	private Categoria categoriaProdotto;
	private String srcImgProdotto;
	
	public Prodotto() 
	{
		//
	}


	/*----------Metodi get e set---------------- */
	
	public int getIdProdotto() 
	{
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) 
	{
		this.idProdotto = idProdotto;
	}

	public String getNomeProdotto()
	{
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) 
	{
		this.nomeProdotto = nomeProdotto;
	}

	public int getQuantitaDisponibile()
	{
		return quantitaDisponibile;
	}

	public void setQuantitDisponibile(int quantitaDisponibile) 
	{
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public double getPrezzoProdotto() 
	{
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(double prezzoProdotto) 
	{
		this.prezzoProdotto = prezzoProdotto;
	}

	public String getDescrizioneProdotto() 
	{
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) 
	{
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public int getIVAProdotto()
	{
		return IVAProdotto;
	}

	public void setIVAProdotto(int iVAProdotto) 
	{
		IVAProdotto = iVAProdotto;
	}

	public String getDimensioneProdotto()
	{
		return dimensioneProdotto;
	}

	public void setDimensioneProdotto(String dimensioneProdotto) 
	{
		this.dimensioneProdotto = dimensioneProdotto;
	}

	public String getColoreProdotto() 
	{
		return coloreProdotto;
	}

	public void setColoreProdotto(String coloreProdotto)
	{
		this.coloreProdotto = coloreProdotto;
	}

	public Categoria getCategoriaProdotto() 
	{
		return categoriaProdotto;
	}

	public void setCategoriaProdotto(Categoria categoriaProdotto) 
	{
		this.categoriaProdotto = categoriaProdotto;
	}

	public String getSrcImgProdotto() 
	{
		return srcImgProdotto;
	}


	public void setSrcImgProdotto(String srcImgProdotto)
	{
		this.srcImgProdotto = srcImgProdotto;
	}
	

	/*------------Fine metodi get e set ------------------*/
	
	
	/* ------------Metodo equals ------------------*/

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (idProdotto != other.idProdotto)
			return false;
		return true;
	}


	
	
	/*-----------Fine metodo equals -------------------*/
	
	
	/*----Metodi prodotto -----*/
	
	public double getPrezzoConIva()
	{
		return this.prezzoProdotto + ((this.prezzoProdotto/100) *this.IVAProdotto);
	}
	
	
	
}
