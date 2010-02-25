package be.xios.ladadv;

import java.util.Scanner;

public class Testauteur 
{
	private static Boek boek;
	
	static Scanner sc = new Scanner( System.in );
	public static void main(String[] args) {
		boek = new Boek();
		System.out.print( "titel please: ");
		boek.setTitel(sc.nextLine());
		
		System.out.print("Naam please: ");
		boek.getAuteur().setNaam(sc.nextLine());
		System.out.print("Voornaam please: ");
		boek.getAuteur().setVoornaam(sc.nextLine());
		
		System.out.println( boek );
	}
}
