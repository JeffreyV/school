package be.xios.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;

import sun.font.EAttribute;

import java.awt.Label;

public class ComplexereGUI
{
    private ClosableFrame frame;
    private SuperPanel topPanel, leftPanel, southEastPanel;
    
    public ComplexereGUI()
    {
	
    }
    
    public static void main( String[] args )
    {
	new ComplexereGUI().createGUI();
    }
    
    public void createGUI()
    {
	frame = new ClosableFrame("JAVA COMPLEXE GUI");
	frame.setLayout( new BorderLayout() );
	
	topPanel = new SuperPanel(new FlowLayout(FlowLayout.LEFT));
	
	CheckboxGroup group = new CheckboxGroup();
	topPanel.add_multi( new Checkbox("Red", group, true ),
		new Checkbox("Blue", group, false ),
		new Checkbox("Green", group, false ));
	
	frame.add( topPanel, BorderLayout.NORTH );
	
	leftPanel = new SuperPanel();
	leftPanel.setLayout( new BorderLayout() );
	
	Panel tmp_panel = new Panel();
	tmp_panel.setLayout( new GridLayout(3,1) );
	tmp_panel.add( new FlashingButton("Bold", 1000) );
	tmp_panel.add( new FlashingButton("Italic", 2000));
	tmp_panel.add( new FlashingButton("Plain", 3000) );
	leftPanel.add( tmp_panel, BorderLayout.NORTH );
	
	leftPanel.add( new Button("Exit"), BorderLayout.SOUTH );	
	frame.add( leftPanel, BorderLayout.WEST );
	
	southEastPanel = new SuperPanel(new BorderLayout());
	
	Panel top = new Panel(new GridLayout(1,1));
	TextArea area = new TextArea();
	area.setText( "Goede morgen" );
	
	top.add( area );
	southEastPanel.add( top );
	
	Panel south = new Panel();
	south.setLayout( new GridLayout(2,2) );
	south.add( new FlashingButton("Nederlands", 4000) );
	south.add( new FlashingButton("Frans",5000) );
	south.add( new FlashingButton("Italiaans", 6000) );
	south.add( new FlashingButton("Engels", 7000) );

	southEastPanel.add( south, BorderLayout.SOUTH);
	frame.add( southEastPanel, BorderLayout.CENTER );
	
	frame.add( new Label("YEAAAAH"), BorderLayout.SOUTH );
	
	frame.setVisible( true );
	frame.pack();
	frame.setSize( 400,400 );
    }
}
