package be.xios.ladadv;

public class VolleybalSpeler 
{
	private String naam;
	private String voornaam;
	private Adres adres;
	private int lidNummer;
	private Ploeg ploeg;
	private int rugNummer;
	
	public VolleybalSpeler(String naam, String voornaam, Adres adres, int nr) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.lidNummer = nr;
	}
	
	

	@Override
	public String toString() {
		return "VolleybalSpeler [naam=" + naam + ", voornaam=" + voornaam + "]";
	}



	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public int getLidNummer() {
		return lidNummer;
	}

	public void setLidNummer(int lidNummer) {
		this.lidNummer = lidNummer;
	}

	public Ploeg getPloeg() {
		return ploeg;
	}

	public void setPloeg(Ploeg ploeg) {
		this.ploeg = ploeg;
	}

	public int getRugNummer() {
		return rugNummer;
	}

	public void setRugNummer(int rugNummer) {
		this.rugNummer = rugNummer;
	}
}
