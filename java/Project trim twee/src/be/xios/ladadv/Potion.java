package be.xios.ladadv;

public class Potion extends Item
{
	private int	recovery;

	public Potion()
	{
		super(); // Call de constructor van Item met geen argumenten..
		this.setRecovery( 0 );
	}

	public void setRecovery( int recovery )
	{
		this.recovery = recovery;
	}

	public int getRecovery()
	{
		return recovery;
	}

	public String toString()
	{
		return String.format(
				"This is a potion named %s and it costs %d, heals %d",
				this.name, this.price, this.recovery );
	}
}
