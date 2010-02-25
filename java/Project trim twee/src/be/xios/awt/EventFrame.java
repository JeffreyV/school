package be.xios.awt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventFrame
{
    private static ClosableFrame frame;
    private static Panel	 panel;
    private static Label	 lbl_a;

    private static final int     SCR_WIDTH  = Toolkit.getDefaultToolkit()
						    .getScreenSize().width;
    private static final int     SCR_HEIGHT = Toolkit.getDefaultToolkit()
						    .getScreenSize().height;

    public static void main( String[] args )
    {
	java.awt.EventQueue.invokeLater( new Runnable()
	{
	    @Override
	    public void run()
	    {
		new EventFrame().createGUI();
	    }
	} );
    }

    private void createGUI()
    {
	frame = new ClosableFrame( "Events!!!" );
	frame.setSize( 400, 400 );
	frame.setVisible( true );
	frame.setLayout( new BorderLayout( 10, 10 ) );

	panel = new Panel();
	panel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
	lbl_a = new Label();
	lbl_a.setText( "Actions" );
	lbl_a.setPreferredSize( new Dimension( 1000, 25 ) );
	panel.add( lbl_a );

	// Add a window listener to frame
	frame.addWindowFocusListener( new WindowAdapter()
	{
	    public void windowLostFocus( WindowEvent e )
	    {
		lbl_a.setText( "LOST FOCUS" );
	    }
	} );

	lbl_a.addMouseListener( new MouseAdapter()
	{
	    public void mouseClicked( MouseEvent e )
	    {
		lbl_a.setText( "Yous clicked on me!!!" );
	    }

	    public void mouseEntered( MouseEvent e )
	    {
		lbl_a.setText( "You entered the label" );

		frame.setLocation( frame.getBounds().x + 10,
			frame.getBounds().y + 10 );
	    }
	} );

	frame.add( panel, BorderLayout.SOUTH );

	// Make the frame bounce
	new Thread( new Runnable()
	{
	    @Override
	    public void run()
	    {
		while (true)
		{
		    
		    
		    int x = frame.getBounds().x;
		    int y = frame.getBounds().y;

		    if (y > 0)
		    {
			frame.setLocation( x, ++y );
		    }

		    try
		    {
			Thread.sleep( 100 );
		    }
		    catch (Exception e)
		    {
			// TODO: handle exception
		    }
		}
	    }
	} ).start();
    }
}
