package be.xios.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosableFrame extends Frame
{
    public ClosableFrame()
    {
	super();
	addWindowCloser();
    }

    public ClosableFrame( GraphicsConfiguration gc )
    {
	super( gc );
	addWindowCloser();
    }

    public ClosableFrame( String title, GraphicsConfiguration gc )
    {
	super( title, gc );
	addWindowCloser();
    }

    public ClosableFrame( String title ) throws HeadlessException
    {
	super( title );
	addWindowCloser();
    }

    private void addWindowCloser()
    {
	addWindowListener( new WindowAdapter()
	{
	    public void windowClosing( WindowEvent we )
	    {
		setVisible( false );
		dispose();
		System.exit( 0 );
	    }
	} );
    }

    @Override
    public Component add( Component comp )
    {
        if ( comp instanceof Button )
        {
            ((Button)comp).setBackground( Color.BLACK );
            ((Button)comp).setForeground( Color.WHITE );
        }

	return super.add( comp );
    }
    
    public void add_multi( Component ... comps )
    {
	for ( Component comp : comps )
	{
	    super.add( comp );
	}
    }
    
    public void add( Component comp, Object constraints )
    {
        if ( comp instanceof Button )
        {
            ((Button)comp).setBackground( Color.BLACK );
            ((Button)comp).setForeground( Color.WHITE );
        }
	
	super.add( comp, constraints );
    }
}
