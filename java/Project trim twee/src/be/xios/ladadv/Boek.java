package be.xios.ladadv;

public class Boek 
{
	private String titel;
	private Auteur auteur;
	
	public Boek()
	{
		this.auteur = new Auteur();
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
	@Override
	public String toString() {
		return "Titel: " + titel + "\nAuteur: " + auteur;
	}
}
