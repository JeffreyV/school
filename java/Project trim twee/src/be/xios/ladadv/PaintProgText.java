package be.xios.ladadv;

import java.awt.Color;

import be.xios.graphics.Coordinate;
import be.xios.graphics.TextShape;

public class PaintProgText
{
    private static TextShape shapes[] = new TextShape[3];

    public static void main( String[] args )
    {
	shapes[0] = new TextShape( new Coordinate(20,10), Color.BLACK, "Hallo");	
	shapes[1] = new TextShape( new Coordinate(20,10), Color.GREEN, "Hi there");	
	shapes[2] = new TextShape( new Coordinate(20,10), Color.CYAN, "yooo" );
	
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

