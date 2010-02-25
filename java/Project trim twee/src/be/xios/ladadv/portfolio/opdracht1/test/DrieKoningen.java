package be.xios.ladadv.portfolio.opdracht1.test;

import java.awt.Color;

import be.xios.ladadv.portfolio.opdracht1.Koning;

public class DrieKoningen 
{

	private static Koning koning, koning2, koning3;
	
	public static void main(String[] args) 
	{
		koning = new Koning( new Color(255,0,0) );
		koning.setNaam("Caspar");
		koning.setKado("wierook");
		
		koning2 = new Koning( "Melchior" );
		koning2.setKleur( new Color(255,255,0) );
		koning2.setKado("goud");
		
		koning3 = new Koning("Balthasar", new Color(0,0,0) );
		koning3.setKado("mirre");
		
		System.out.println(koning2);		
		System.out.println(koning);		
		System.out.println(koning3);
	}
}
