package be.xios.ladadv;

public class Ploeg 
{
	private String naam;
	private Trainer trainer;
	private VolleybalSpeler spelers[];
	private int aantalSpelers;
	
	public Ploeg( String naam ) {
		this.naam = naam;
		this.spelers = new VolleybalSpeler[12];
		this.aantalSpelers = 0;
	}

	public VolleybalSpeler[] getSpelers() {
		return spelers;
	}

	public void setSpelers(VolleybalSpeler[] spelers) {
		this.spelers = spelers;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public int getAantalSpelers() {
		return aantalSpelers;
	}

	public void setAantalSpelers(int aantalSpelers) {
		this.aantalSpelers = aantalSpelers;
	}
	
	public VolleybalSpeler getVolleybalSpeler(String naam)
	{
		for ( int i = 0; i < aantalSpelers; i++ )
		{
			if ( String.format("%s %s", 
					spelers[i].getNaam(), 
					spelers[i].getVoornaam()).equals(naam) )
			{
				return spelers[i];
			}
		}
		
		return null;
	}
	
	public void voegVolleybalSpelerToe( VolleybalSpeler speler )
	{
		if ( this.aantalSpelers < 12 )
		{
			this.spelers[aantalSpelers] = new VolleybalSpeler(
					speler.getNaam(), 
					speler.getVoornaam(), 
					speler.getAdres(), 
					speler.getLidNummer());
			
			aantalSpelers++;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"Ploeg: %s " +
				"\nTrainer: %s %s "
				, this.naam
				, trainer.getNaam()
				, trainer.getVoornaam());
	}
}