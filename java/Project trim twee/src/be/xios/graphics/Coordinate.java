package be.xios.graphics;

public class Coordinate
{
    private int x;
    private int y;

    public Coordinate()
    {
	this.x = 0;
	this.y = 0;
    }
    
    public Coordinate( int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    
    /**
     * @param x
     *            the x to set
     */
    public void setX( int x )
    {
	this.x = x;
    }

    /**
     * @return the x
     */
    public int getX()
    {
	return x;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY( int y )
    {
	this.y = y;
    }

    /**
     * @return the y
     */
    public int getY()
    {
	return y;
    }

    @Override
    public String toString()
    {
	return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals( Object obj )
    {
	if (obj == null)
	{
	    return false;
	}
	else if (this.getClass() != obj.getClass())
	{
	    return false;
	}
	else
	{
	    Coordinate temp = (Coordinate) obj;
	    if (this.x == temp.getX() && this.y == temp.getY())
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
    }
}
