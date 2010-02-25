package be.xios.painter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import be.xios.graphics.Shape;

public class PaintCanvas extends Canvas
{
    private Shape shapes[];
    private int index;
    
    public PaintCanvas()
    {
	// Initialize member variables
	this.shapes = new Shape[20];
	this.index = 0;
	
	this.setBackground( Color.YELLOW );
    }
    
    @Override
    public void paint( Graphics g )
    {
        for ( int i = 0; i < index; i++ ) {
            shapes[i].draw(g);
        }
    }
    
    public void addShape(Shape shape)
    {
	if ( index < 20 )
	{
	    shapes[index] = shape;
	    index++;
	    repaint();
	}
    }
}
