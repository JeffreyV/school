package be.xios.polymorphisme;

public class Dier
{
    private static int aantal;
    
    public Dier()
    {
	System.out.println( "ik ben een dier" );
    }
    
    public void eten()
    {
	System.out.println( "food please" );
    }
    
    public static int getAantal()
    {
	return aantal; 
    }
}
