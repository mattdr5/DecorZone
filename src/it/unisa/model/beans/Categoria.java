package it.unisa.model.beans;

/**
 * Contiene i dati di una singola categoria. Presenta principalmente metodi get e set,
 *  ed un metodo per verificare quando due categorie sono uguali 
 * @author Matteo Della Rocca
 * @author Luca Boffa
 *
 */
public class Categoria 
{
	private int idCategoria;
	private String nomeCategoria;
	private String srcImg;
	
	public Categoria() 
	{
		//
	}
	
	
	/*-------------Metodi get e set------------------------- */
	
	public int getIdCategoria() 
	{
		
		return idCategoria;
		
	}
	
	public String getNomeCategoria() 
	{
		return nomeCategoria;
		
	}
	
	public void setIdCategoria(int idCategoria) 
	{
		this.idCategoria = idCategoria;
		
	}
	
	public void setNomeCategoria(String nomeCategoria) 
	{
		
		this.nomeCategoria = nomeCategoria;
		
	}
	

	public String getSrcImg() {
		return srcImg;
	}


	public void setSrcImg(String srcImg) {
		this.srcImg = srcImg;
	}
	

	/*-------------- Fine metodi get e set------------------- */
	
	
	
	/*---------------- Metodo equals-------------------------- */
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (idCategoria != other.idCategoria)
			return false;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		return true;
	}


	/*------------------ Fine metodo equals--------------------- */
	
	
}
