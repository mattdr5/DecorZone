package it.unisa.model.beans;

/**
 * Contiene i dati di una singola carta. Presenta principalmente metodi get e set,
 *  ed un metodo per verificare quando due carte sono uguali 
 * @author Matteo Della Rocca
 * @author Luca Boffa
 *
 */
public class Carta {
	
	private String numCarta;
	private String cvc;
	private String user;
	private double saldo;
	
	
	public Carta(){
		//
	}


	public String getNumCarta() {
		return numCarta;
	}


	public void setNumCarta(String numCarta) {
		this.numCarta = numCarta;
	}


	public String getCvc() {
		return cvc;
	}


	public void setCvc(String cvc) {
		this.cvc = cvc;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (cvc == null) {
			if (other.cvc != null)
				return false;
		} else if (!cvc.equals(other.cvc))
			return false;
		if (numCarta == null) {
			if (other.numCarta != null)
				return false;
		} else if (!numCarta.equals(other.numCarta))
			return false;
		return true;
	}

	
}
