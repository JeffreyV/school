package be.xios.ladadv;

public class TestItem
{
	public static void main( String[] args )
	{
		Item item = new Item();
		item.setName( "Standaard item" );
		item.setPrice( 50 );
		
		System.out.println( item ); // toString van Item klasse
		
		Potion potion = new Potion();
		potion.setName( "Health potion" );
		potion.setPrice( 100 );
		potion.setRecovery( 20 );
		
		System.out.println(potion); // toString van Potion klasse
	}
}
