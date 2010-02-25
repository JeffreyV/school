package be.xios.awt;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.sun.media.sound.Toolkit;

import be.xios.graphics.Coordinate;

public class ColorFrames extends WindowAdapter
{
    private Frame      frames[] = new Frame[10];
    private Frame      frame;
    private int	index;
    private int	breedte;
    private int	hoogte;
    private Color      kleur;
    private Coordinate coord;

    public ColorFrames( int index, int breedte, int hoogte, Color kleur, int x,
	    int y )
    {
	this.coord = new Coordinate();
	this.index = index;
	this.breedte = breedte;
	this.hoogte = hoogte;
	this.kleur = kleur;
	this.coord.setX( x );
	this.coord.setY( y );
    }

    public static void main( String[] args )
    {
	int b = 600;
	int h = 600;
	Color k;
	ColorFrames frames[] = new ColorFrames[10];
	int x = 0;
	int y = 0;

	for (int i = 0; i < frames.length; ++i)
	{
	    k = new Color( (int) (Math.random() * 256),
		    (int) (Math.random() * 256), (int) (Math.random() * 256) );
	    frames[i] = new ColorFrames( i, b, h, k, x, y );
	    frames[i].buildGUI();
	    b -= 50;
	    h -= 50;
	    x += 25;
	    y += 25;
	}
    }

    public int getIndex()
    {
	return this.index;
    }

    public void buildGUI()
    {
	frame = new Frame( "Frame" + index );
	frame.setBackground( kleur );
	frame.setSize( breedte, hoogte );
	frame.setVisible( true );
	frame.addWindowListener( this );
	frame.setLocation( this.coord.getX(), this.coord.getY() );

	this.frames[this.index] = frame;
	
	frame.addMouseListener( new MouseAdapter()
	{
	    public void mouseClicked( MouseEvent e )
	    {
		Dimension screenW = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int res = java.awt.Toolkit.getDefaultToolkit().getScreenResolution();
		System.out.printf( "Screen width: %.0f\nScreen height: %.0f\n" +
				"Screen Resolution: %s\n", 
				screenW.getWidth(),
				screenW.getHeight(),
				String.valueOf( res ));
	    }

	    public void mouseDragged( MouseEvent e )
	    {
		Point p = e.getPoint();
		System.out.println( "test" );
	    }
	} );
	
	new Thread( new Runnable()
	{
	    
	    @Override
	    public void run()
	    {
		while ( true )
		{
		    frame.setBackground( new Color((int) (Math.random() * 256),
		    (int) (Math.random() * 256), (int) (Math.random() * 256)) );
		    try
		    {
			Thread.sleep( 200 );
		    }
		    catch (Exception e)
		    {
			// TODO: handle exception
		    }
		}
		
	    }
	}).start();
    }

    public void windowClosing( WindowEvent we )
    {
	frame.setVisible( false );
	frame.dispose();
	System.exit( 0 );
    }
}
