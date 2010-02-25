package be.xios.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape
{
    protected Coordinate start;
    protected Color color;

    public Shape()
    {
	// TODO Auto-generated constructor stub
    }

    public abstract void draw();
    public abstract void draw(Graphics g);

    /**
     * @return the start
     */
    public Point getStart()
    {
	return new Point( this.start.getX(), this.start.getY() );
    }

    /**
     * @param start
     *            the start to set
     */
    public void setStart( Coordinate start )
    {
	this.start = start;
    }

    /**
     * @return the color
     */
    public Color getColor()
    {
	return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor( Color color )
    {
	this.color = color;
    }

    @Override
    public String toString()
    {
	return String.format( "Shape: coordinate (%d, %d) kleur: %s",
		this.start.getX(), this.start.getY(), this.color );
    }
}
