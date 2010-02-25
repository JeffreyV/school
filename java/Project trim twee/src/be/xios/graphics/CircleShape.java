package be.xios.graphics;

import java.awt.Color;

public class CircleShape extends OvalShape
{
    public CircleShape( Coordinate start, int width, Color color, boolean isFilled )
    {
	super( start, width, width, color, isFilled );
    }
    
    @Override
    public void setHeigth( int height )
    {
        super.setWidth( height );
        super.setHeigth( height );
    }
    
    @Override
    public void setWidth( int width )
    {
        super.setHeigth( width );
        super.setWidth( width );
    }
    
    public void draw()
    {
	System.out.printf( "Circle: start: %s, width: %d, height: %d, kleur: %s, " +
		"filled: %s\n", 
		this.getStart(),
		this.getWidth(),
		this.getHeight(),
		this.getColor(),
		this.isFilled());
    }
}
