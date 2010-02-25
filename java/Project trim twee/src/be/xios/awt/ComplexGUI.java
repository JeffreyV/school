package be.xios.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class ComplexGUI
{
    private ClosableFrame frame;

    public static void main( String[] args )
    {
	new ComplexGUI().createGUI();
    }

    public void createGUI()
    {
	frame = new ClosableFrame();
	frame.setLayout( new BorderLayout( 10, 10 ) );

	TextField field = new TextField();
	frame.add( field, BorderLayout.NORTH );

	Panel panel = new Panel();
	panel.setLayout( new GridLayout( 4, 3 ) );

	for (int i = 0; i < 9; i++)
	{
	    Button b = new FlashingButton( "" + (i + 1), 100 );
	    panel.add( b );
	}

	panel.add( new Button( "+" ) );
	panel.add( new Button( "0" ) );
	panel.add( new Button( "*" ) );

	frame.add( panel, BorderLayout.CENTER );
	frame.add( new Button("Kies het gekozen nummer"), BorderLayout.SOUTH );

	frame.setVisible( true );
	frame.pack();
	frame.setSize( 400, 400 );
    }
}
