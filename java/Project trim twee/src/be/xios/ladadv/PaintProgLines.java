package be.xios.ladadv;

import java.awt.Color;

import be.xios.graphics.Coordinate;
import be.xios.graphics.LineShape;

public class PaintProgLines
{
    private static LineShape[] drawingshape = new LineShape[3];

    public static void main( String[] args )
    {
	drawingshape[0] = new LineShape( new Coordinate( 10, 20 ),
		new Coordinate( 15, 30 ), Color.BLUE );
	drawingshape[1] = new LineShape( new Coordinate( 10, 25 ),
		new Coordinate( 15, 35 ), Color.RED );
	drawingshape[2] = new LineShape( new Coordinate( 50, 50 ),
		new Coordinate( 70, 80 ), Color.GREEN );
	
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
	for (int i = 0; i < drawingshape.length; i++)
	{
	    drawingshape[i].draw();
	}
    }
}
