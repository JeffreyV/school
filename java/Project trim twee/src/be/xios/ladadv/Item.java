package be.xios.ladadv;

public class Item
{
	/*
	 * Protected keyword betekent dat deze enkel kunne gebruikt worden in deze klasse
	 * maar ook in subklassen, private zou dit niet toelaten.
	 */
	protected int		price; 
	protected String	name;
	
	public Item()
	{
		setPrice(0);
		setName(null);
	}

	public void setPrice( int price )
	{
		this.price = price;
	}

	public int getPrice()
	{
		return price;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return String.format( "This item's name is: %s and it costs %d", this.name, this.price );
	}
}
