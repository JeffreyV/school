package be.xios.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class LineShape extends Shape
{
    private Coordinate end;

    public LineShape()
    {

    }

    public LineShape( Coordinate start, Coordinate end, Color color )
    {
	this.setStart( start );
	this.setEnd( end );
	this.setColor( color );
    }

    @Override
    public void draw()
    {
	System.out.printf( "Line: start: %s, end: %s, Kleur: %s\n", this.start,
		this.end, this.color );
    }

    /**
     * @param end
     *            the end to set
     */
    public void setEnd( Coordinate end )
    {
	this.end = end;
    }

    /**
     * @return the end
     */
    public Coordinate getEnd()
    {
	return end;
    }

    public void lineOnly()
    {
	System.out.println( "This is a line!!!!" );
    }

    public void draw( Graphics g )
    {
	g.setColor( this.color );

	g.drawLine( this.getStart().x, this.getStart().y, this.getEnd().getX(),
		this.getEnd().getY() );
    }
}
