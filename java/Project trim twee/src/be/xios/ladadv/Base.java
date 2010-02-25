package be.xios.ladadv;

public class Base 
{
	protected int x = 20;
	protected int y;
	
	public static void main(String[] args) 
	{
		MegaBase mbase = new MegaBase();
		System.out.println( mbase.x + ", " + mbase.y );
	}
}
