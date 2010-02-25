package be.xios.ladadv;

import java.util.Scanner;

public class TestPloegen 
{
	private static Ploeg ploegske;
	private static Trainer trainerke;
	private static VolleybalSpeler spelerke;
	
	private static Scanner sc = new Scanner( System.in );
	public static void main(String[] args) {
		System.out.print("Geef een ploeg in: ");
		ploegske = new Ploeg( sc.nextLine() );
		
		String naam, voornaam, straat, gemeente;
		int nummer, postcode;
		System.out.println("Geef de gegevens van de trainer in: ");
		System.out.print("Voornaam: ");
		voornaam = sc.nextLine();
		System.out.print("Naam: ");
		naam = sc.nextLine();
		System.out.print("straat");
		straat = sc.nextLine();
		System.out.print("nummer: ");
		nummer = Integer.parseInt(sc.nextLine());
		System.out.print("postcode: ");
		postcode = Integer.parseInt(sc.nextLine());
		System.out.print("gemeente: ");
		gemeente = sc.nextLine();
		
		Adres adreske = new Adres();
		adreske.setGemeente( gemeente );
		adreske.setNummer(nummer);
		adreske.setPostcode(postcode);
		adreske.setStraat(straat);
		
		trainerke = new Trainer(naam, voornaam, adreske,0 );
		ploegske.setTrainer( trainerke );
		
		System.out.println("Geef volleybalspeler in: ");				
		String input = "";
		do
		{
			System.out.print("Voornaam: ");
			voornaam = sc.nextLine();
			System.out.print("Naam: ");
			naam = sc.nextLine();
			System.out.print("straat");
			straat = sc.nextLine();
			System.out.print("nummer: ");
			nummer = Integer.parseInt(sc.nextLine());
			System.out.print("postcode: ");
			postcode = Integer.parseInt(sc.nextLine());
			System.out.print("gemeente: ");
			gemeente = sc.nextLine();
			
			adreske = new Adres();
			adreske.setGemeente( gemeente );
			adreske.setNummer(nummer);
			adreske.setPostcode(postcode);
			adreske.setStraat(straat);
			
			if ( ploegske.getAantalSpelers() < 12 )
			{
				ploegske.voegVolleybalSpelerToe(new VolleybalSpeler(
						naam, 
						voornaam, 
						adreske, 
						0));
			}
			
			System.out.print("Nog ne speler toevoegen (Y/n)" );
			input = sc.nextLine();
		} while ( input.charAt(0) == 'Y' || 
				input.charAt(0) == 'y' );		
		
		
		System.out.println( "Van welke speler wilt ge het rugnummer" +
				"kiezen? ( naam en voornaam )");
		
		String naamenvoornaam = sc.nextLine();
		
		spelerke = ploegske.getVolleybalSpeler(naamenvoornaam);
		
		if ( spelerke != null )
		{
			System.out.println( spelerke );
			System.out.print("Geef het rugnummer in: ");
			spelerke.setLidNummer( sc.nextInt() );
		}
		else
		{
			System.out.println( "Niet gevonden" );
		}
		
		System.out.println( "Ploegvoorstelling: ");
		System.out.println( ploegske );
		
		for ( VolleybalSpeler s : ploegske.getSpelers() )
		{
			if ( s != null )
			{
				System.out.println( s.getNaam() + " " + s.getVoornaam() );
				if ( s.getLidNummer() != 0 )
				{
					System.out.println("Rugnummer: " + s.getLidNummer() );
				}
			}
		}
	}
}
