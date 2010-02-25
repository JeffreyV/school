package be.xios.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class TextShape extends Shape
{
    private String text;

    public TextShape()
    {
    }

    public TextShape( Coordinate start, Color color, String text )
    {
	this.setColor( color );
	this.setText( text );
	this.setStart( start );
    }

    @Override
    public void draw()
    {
	System.out.println( "Text: start: " + this.getStart() + " Kleur: "
		+ this.getColor() + " Tekst: " + this.getText() );
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText( String text )
    {
	this.text = text;
    }

    /**
     * @return the text
     */
    public String getText()
    {
	return text;
    }

    public void draw( Graphics g )
    {
	g.setColor( this.color );

	g.drawString( this.getText(), this.getStart().x, this.getStart().y );
    }
}
