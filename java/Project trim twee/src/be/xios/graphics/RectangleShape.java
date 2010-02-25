package be.xios.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleShape extends Shape
{
    private int     width;
    private int     height;
    private boolean filled;

    public RectangleShape( Coordinate start, int width, int height,
	    Color color, boolean filled )
    {
	this.setStart( start );
	this.setColor( color );
	this.setFilled( filled );
	this.setWidth( width );
	this.setHeight( height );
    }

    public void draw()
    {
	System.out.printf(
		"Rectangle: start: %s, width: %d, height: %d, kleur: %s, "
			+ "filled: %s\n", this.getStart(), this.getWidth(),
		this.getHeight(), this.getColor(), this.isFilled() );
    }

    /**
     * @param filled
     *            the filled to set
     */
    public void setFilled( boolean filled )
    {
	this.filled = filled;
    }

    /**
     * @return the filled
     */
    public boolean isFilled()
    {
	return filled;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight( int height )
    {
	this.height = height;
    }

    /**
     * @return the height
     */
    public int getHeight()
    {
	return height;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth( int width )
    {
	this.width = width;
    }

    /**
     * @return the width
     */
    public int getWidth()
    {
	return width;
    }

    public void draw( Graphics g )
    {
	g.setColor( this.color );

	if (!filled)
	{
	    g.drawRect( this.getStart().x, this.getStart().y, this.getWidth(),
		    this.getHeight() );
	}
	else
	{
	    g.fillRect( this.getStart().x, this.getStart().y, this.getWidth(),
		    this.getHeight() );
	}
    }
}
