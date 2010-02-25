package be.xios.painter;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

import be.xios.graphics.Coordinate;
import be.xios.graphics.LineShape;
import be.xios.graphics.OvalShape;
import be.xios.graphics.RectangleShape;
import be.xios.graphics.Shape;
import be.xios.graphics.TextShape;

public class PaintFrame extends Frame
{
    private Panel       shape_panel, pref_panel, color_panel, top_pref_panel;
    private Button      btn_line, btn_rect, btn_oval, btn_text;
    private Label       r, g, b;
    private TextField   txt_r, txt_g, txt_b, txt_start_x, txt_end_x;
    private TextField   txt_start_y, txt_end_y, txt_width, txt_height,
	    txt_text;
    private Checkbox    chkFilled;
    private PaintCanvas pnt_canvas;
    private Color       clr_paint_color;
    private Font	fnt_selected_font, fnt_normal_font;
    private Label	lbl_current_color;

    /*
     * ===================================== Main Function
     * =======================================
     */
    public static void main( String args[] )
    {
	// Make a new instance of the frame using AWT EventQueue
	java.awt.EventQueue.invokeLater( new Runnable()
	{
	    @Override
	    public void run()
	    {
		new PaintFrame( "UBUNTU PAINTER!!!!!!!!!!!!!!!!!!!!" );
	    }
	} );
    }

    public PaintFrame() throws HeadlessException
    {
	super();

	// Create GUI
	createGUI();
    }

    public PaintFrame( String title ) throws HeadlessException
    {
	super( title );

	// Create GUI
	createGUI();
    }

    public void createGUI()
    {
	pnt_canvas = new PaintCanvas();

	// Default font
	clr_paint_color = new Color(0,0,0);

	// Selected font
	fnt_selected_font = new Font( "Monospace", Font.BOLD, 25 );
	fnt_normal_font = new Font( "Monospace", Font.BOLD, 12 );

	// Use a border layout
	this.setLayout( new BorderLayout() );

	// Add a window closing method
	this.addWindowListener( new WindowAdapter()
	{
	    public void windowClosing( WindowEvent we )
	    {
		setVisible( false );
		dispose();
		System.exit( 0 );
	    }
	} );

	this.setSize( 600, 400 );
	this.setVisible( true );

	// Make the left panel
	shape_panel = new Panel( new GridLayout( 4, 1 ) );
	shape_panel.setPreferredSize( new Dimension( 100, 400 ) );

	// Make the bottom panel
	pref_panel = new Panel( new GridBagLayout() );

	// Make the panel for the preference panel
	make_preference_comps();

	btn_line = new Button( "Line" );
	btn_line.setFont( fnt_normal_font );
	btn_line.addActionListener( new ActionListener()
	{
	    @Override
	    public void actionPerformed( ActionEvent e )
	    {
		LineShape line = new LineShape();
		line
			.setStart( new Coordinate( Integer
				.parseInt( txt_start_x.getText() ), Integer
				.parseInt( txt_start_y.getText() ) ) );
		line
			.setEnd( new Coordinate( Integer.parseInt( txt_end_x
				.getText() ), Integer.parseInt( txt_end_y
				.getText() ) ) );
		line.setColor( clr_paint_color );

		pnt_canvas.addShape( line );
	    }
	} );

	btn_rect = new Button( "Rectangle" );
	btn_rect.setFont( fnt_normal_font );
	btn_rect.addActionListener( new ActionListener()
	{
	    @Override
	    public void actionPerformed( ActionEvent e )
	    {
		RectangleShape shape = new RectangleShape( new Coordinate(
			Integer.parseInt( txt_start_x.getText() ), Integer
				.parseInt( txt_start_y.getText() ) ), Integer
			.parseInt( txt_width.getText() ), Integer
			.parseInt( txt_height.getText() ), clr_paint_color,
			chkFilled.getState() );

		pnt_canvas.addShape( shape );
	    }
	} );

	btn_oval = new Button( "Oval" );
	btn_oval.setFont( fnt_normal_font );
	btn_oval.addActionListener( new ActionListener()
	{
	    @Override
	    public void actionPerformed( ActionEvent e )
	    {
		OvalShape shape = new OvalShape( new Coordinate(
			Integer.parseInt( txt_start_x.getText() ), Integer
				.parseInt( txt_start_y.getText() ) ), Integer
			.parseInt( txt_width.getText() ), Integer
			.parseInt( txt_height.getText() ), clr_paint_color,
			chkFilled.getState() );

		pnt_canvas.addShape( shape );
	    }
	} );

	btn_text = new Button( "Text" );
	btn_text.addActionListener( new ActionListener()
	{
	    @Override
	    public void actionPerformed( ActionEvent e )
	    {
		TextShape shape = new TextShape( new Coordinate(
			Integer.parseInt( txt_start_x.getText() ), Integer
				.parseInt( txt_start_y.getText() ) ), clr_paint_color,
			txt_text.getText() );

		pnt_canvas.addShape( shape );
	    }
	} );
	btn_text.setFont( fnt_normal_font );

	// Add buttons to shape panel
	shape_panel.add( btn_line );
	shape_panel.add( btn_rect );
	shape_panel.add( btn_oval );
	shape_panel.add( btn_text );

	// Add the shape panel to the west
	this.add( shape_panel, BorderLayout.WEST );

	// Add pref panel to south
	this.add( pref_panel, BorderLayout.SOUTH );

	// Make the canvas and add it
	pnt_canvas = new PaintCanvas();
	this.add( pnt_canvas, BorderLayout.CENTER );
    }
    
    private void update_color()
    {
	this.lbl_current_color.setBackground( clr_paint_color );
    }

    private void make_preference_comps()
    {
	pref_panel = new Panel();
	pref_panel.setLayout( new GridBagLayout() );
	GridBagConstraints c = new GridBagConstraints();

	Label r, g, b;
	r = new Label( "r" );
	r.setBackground( Color.RED );
	r.setAlignment( Label.RIGHT );

	g = new Label( "g" );
	g.setBackground( Color.GREEN );
	g.setAlignment( Label.RIGHT );

	b = new Label( "b" );
	b.setBackground( Color.BLUE );
	b.setAlignment( Label.RIGHT );

	txt_r = new TextField();
	txt_r.addKeyListener( new KeyAdapter()
	{
	    public void keyReleased( KeyEvent ke )
	    {
		try
		{
		    clr_paint_color = new Color( Integer.parseInt( txt_r
			    .getText() ), Integer.parseInt( txt_g.getText() ),
			    Integer.parseInt( txt_b.getText() ) );
		    
		    lbl_current_color.setBackground( clr_paint_color );
		}
		catch (IllegalArgumentException e)
		{
		    txt_r.setText( String.format( "%d", 0 ) );
		    clr_paint_color = new Color( Integer.parseInt( txt_r
			    .getText() ), Integer.parseInt( txt_g.getText() ),
			    Integer.parseInt( txt_b.getText() ) );
		    update_color();
		    txt_r.selectAll();
		    System.err.println( e.getMessage() );
		}
	    }
	} );
	txt_r.setText( String.valueOf( 0 ) );

	txt_g = new TextField();
	txt_g.addKeyListener( new KeyAdapter()
	{
	    public void keyReleased( KeyEvent ke )
	    {
		try
		{
		    clr_paint_color = new Color( Integer.parseInt( txt_r
			    .getText() ), Integer.parseInt( txt_g.getText() ),
			    Integer.parseInt( txt_b.getText() ) );
		    
		    lbl_current_color.setBackground( clr_paint_color );
		}
		catch (IllegalArgumentException e)
		{
		    txt_g.setText( String.format( "%d", 0 ) );
		    clr_paint_color = new Color( Integer.parseInt( txt_r
			    .getText() ), Integer.parseInt( txt_g.getText() ),
			    Integer.parseInt( txt_b.getText() ) );
		    update_color();
		    txt_g.selectAll();
		    System.err.println( e.getMessage() );
		}
	    }
	} );
	txt_g.setText( String.valueOf( 0 ) );

	txt_b = new TextField();
	txt_b.addKeyListener( new KeyAdapter()
	{
	    public void keyReleased( KeyEvent ke )
	    {
		try
		{
		    clr_paint_color = new Color( Integer.parseInt( txt_r
			    .getText() ), Integer.parseInt( txt_g.getText() ),
			    Integer.parseInt( txt_b.getText() ) );
		    
		    lbl_current_color.setBackground( clr_paint_color );
		}
		catch (IllegalArgumentException e)
		{
		    txt_b.setText( String.format( "%d", 0 ) );
		    clr_paint_color = new Color( Integer.parseInt( txt_r
			    .getText() ), Integer.parseInt( txt_g.getText() ),
			    Integer.parseInt( txt_b.getText() ) );
		    update_color();
		    txt_b.selectAll();
		    System.err.println( e.getMessage() );
		}
	    }
	} );
	txt_b.setText( String.valueOf( 0 ) );

	txt_start_x = new TextField( "0" );
	txt_end_x = new TextField( "0" );

	txt_start_y = new TextField( "0" );
	txt_end_y = new TextField( "0" );

	txt_width = new TextField( "0" );
	txt_height = new TextField( "0" );

	txt_text = new TextField( "Tekst" );
	
	lbl_current_color = new Label();
	lbl_current_color.setBackground( clr_paint_color );

	chkFilled = new Checkbox();
	chkFilled.setState( true );

	/* FIRST ROW */

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	c.weightx = 0.5;
	pref_panel.add( new Label(), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 1;
	c.weightx = 0.5;
	pref_panel.add( new Label( "Start" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 2;
	c.weightx = 0.5;
	pref_panel.add( new Label( "End" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 3;
	c.weightx = 0.5;
	pref_panel.add( new Label( "Color" ), c );

	/* SECOND ROW */

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 0;
	c.weightx = 0.5;
	pref_panel.add( new Label( "X" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 1;
	c.weightx = 0.5;
	pref_panel.add( txt_start_x, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 2;
	c.weightx = 0.5;
	pref_panel.add( txt_end_x, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 3;
	c.weightx = 0.5;
	pref_panel.add( r, c );

	/* Third row */

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 0;
	c.weightx = 0.5;
	pref_panel.add( new Label( "Y" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 1;
	c.weightx = 0.5;
	pref_panel.add( txt_start_y, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 2;
	c.weightx = 0.5;
	pref_panel.add( txt_end_y, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 3;
	c.weightx = 0.5;
	pref_panel.add( txt_r, c );

	/* Fourth row */

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 0;
	c.weightx = 0.5;
	pref_panel.add( new Label( "Width" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 1;
	c.weightx = 0.5;
	pref_panel.add( new Label( "Height" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 2;
	c.weightx = 0.5;
	pref_panel.add( new Label( "Filled" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 3;
	c.weightx = 0.5;
	pref_panel.add( g, c );

	/* Fifth row */

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 0;
	c.weightx = 0.5;
	pref_panel.add( txt_width, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 1;
	c.weightx = 0.5;
	pref_panel.add( txt_height, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 2;
	c.weightx = 0.5;
	pref_panel.add( chkFilled, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 3;
	c.weightx = 0.5;
	pref_panel.add( txt_g, c );

	/* Sixth row */

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 5;
	c.gridy = 0;
	c.weightx = 0.0;
	c.gridwidth = 3;
	pref_panel.add( new Label( "Text" ), c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 5;
	c.gridy = 1;
	c.weightx = 1.0;
	c.gridwidth = 3;
	pref_panel.add( txt_text, c );

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 5;
	c.gridy = 3;
	c.weightx = 0.5;
	c.gridwidth = 1;
	pref_panel.add( b, c );

	/* Seventh row */
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 6;
	c.gridy = 3;
	c.weightx = 0.5;
	c.gridwidth = 1;
	pref_panel.add( txt_b, c );
	
	/* Eigth row */
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 7;
	c.gridy = 3;
	c.weightx = 0.5;
	c.gridwidth = 1;
	pref_panel.add( lbl_current_color, c );
    }
}
