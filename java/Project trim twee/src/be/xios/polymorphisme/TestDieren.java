package be.xios.polymorphisme;

public class TestDieren
{
    public static void main( String[] args )
    {
	Dier snoopy = new Hond();
	snoopy.eten();
	Kat tom = new Kat();
	tom.eten();
	
	
    }
}
