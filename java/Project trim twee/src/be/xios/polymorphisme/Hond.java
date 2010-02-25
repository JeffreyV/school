package be.xios.polymorphisme;

public class Hond extends Dier
{
    public Hond()
    {
	System.out.println( "ik ben ne hond" );
    }

    public void eten()
    {
	System.out.println( "Hondebrokken" );
    }

    public void blaffen()
    {
	System.out.println( "ik blaf.." );
    }
}
