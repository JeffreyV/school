package be.xios.ladadv;

public class Adres 
{
	private String straat;
	private int nummer;
	private int postcode;
	private String gemeente;
	
	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	@Override
	public String toString() {
		return String.format("%s %d\n%d %s" , 
				straat, 
				nummer, 
				postcode, 
				gemeente);
	}
}
