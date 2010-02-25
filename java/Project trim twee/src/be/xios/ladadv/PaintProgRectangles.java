package be.xios.ladadv;

import java.awt.Color;

import be.xios.graphics.Coordinate;
import be.xios.graphics.RectangleShape;

public class PaintProgRectangles
{
    private static RectangleShape shapes[] = new RectangleShape[3];

    public static void main( String[] args )
    {
	shapes[0] = new RectangleShape( new Coordinate( 10, 20 ), 50, 30,
		Color.BLUE, true );
	shapes[1] = new RectangleShape( new Coordinate( 50, 20 ), 20, 30,
		Color.RED, true );
	shapes[2] = new RectangleShape( new Coordinate( 5, 30 ), 10, 15,
		Color.BLACK, false );
	
	repaint();
    }
    
    private static void repaint()
    {
	System.out.println( "Clearing component" );
	System.out.println( "Drawing again" );
	paint();
    }
    
    private static void paint()
    {
	for (int i = 0; i < shapes.length; i++)
	{
	    shapes[i].draw();
	}
    }
}
