package be.xios.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestFrame
{
    private static Frame  frame;
    private static Button button;

    public static void main( String[] args )
    {
	new TestFrame();
    }

    public TestFrame()
    {
	buildGUI();
    }

    public void buildGUI()
    {
	frame = new Frame( "Test" );
	frame.setLayout( null );
	frame.setSize( 400, 400 );
	frame.setVisible( true );
	frame.addWindowListener( new WindowAdapter()
	{
	    public void windowClosing( WindowEvent we )
	    {
		frame.setVisible( false );
		frame.dispose();
		System.exit( 0 );
	    }
	} );

	button = new Button( "klik hier" );
	button.setSize( 100, 100 );
	button.setLocation( 150, 150 );
	button.setBackground( Color.YELLOW );

	frame.add( button );
    }
}
