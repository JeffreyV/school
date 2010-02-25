package be.xios.polymorphisme;

import java.awt.Color;

import be.xios.graphics.Coordinate;
import be.xios.graphics.LineShape;
import be.xios.graphics.RectangleShape;
import be.xios.graphics.Shape;
import be.xios.graphics.SquareShape;

public class DrawAnyShape
{
    public static Shape shapes [] = new Shape[3];
    
    public static void main( String[] args )
    {
	// Teken een lijn, ne rechthoek en een vierkant
	shapes[0] = new LineShape( new Coordinate(10,30), new Coordinate( 10, 30 ), Color.RED );
	shapes[1] = new SquareShape( new Coordinate(20,58), 20, Color.BLACK, true );
	shapes[2] = new RectangleShape( new Coordinate(20,58), 20, 35, Color.BLACK, true );
	repaint();
    }
    
    private static void repaint()
    {
	System.out.println( "Clearen van component" );
	System.out.println( "Shapes worden opnieuw getekent" );
	paint();
    }
    
    private static void paint()
    {
	// Print dat allemaal uit..
	for (int i = 0; i < shapes.length; i++)
	{
	    shapes[i].draw();
	    if ( shapes[i] instanceof LineShape )
	    {
		((LineShape)shapes[i]).lineOnly();
	    }
	}
    }
}
