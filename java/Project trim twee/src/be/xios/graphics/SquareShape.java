package be.xios.graphics;

import java.awt.Color;

public class SquareShape extends RectangleShape
{    
    public SquareShape( Coordinate start, int width, Color color,
	    boolean filled )
    {
	super( start, width, width, color, filled );
    }
    
    @Override
    public void setHeight( int height )
    {
        super.setWidth( height );
        super.setHeight( height );
    }
    
    @Override
    public void setWidth( int width )
    {
	super.setHeight( width );
	super.setWidth( width );
    }

    public void draw()
    {
	System.out.printf( "Square: start: %s, width: %d, height: %d, kleur: %s, " +
		"filled: %s\n", 
		this.getStart(),
		this.getWidth(),
		this.getHeight(),
		this.getColor(),
		this.isFilled());
    }
}
