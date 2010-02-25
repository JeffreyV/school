package be.xios.polymorphisme;

public class Kat extends Dier
{
    public Kat()
    {
	System.out.println("een kat");
    }
    
    public void eten()
    {
	System.out.println("kattenbrokken");
    }
    
    public void miauwen()
    {
	System.out.println( "MIAUW...." );
    }
}
