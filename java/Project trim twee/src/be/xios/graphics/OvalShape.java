package be.xios.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class OvalShape extends Shape {

	private int width;
	private int height;
	private boolean filled;
	
	public OvalShape( Coordinate start, int width, int height, Color color, boolean isFilled )
	{
	    this.setHeigth( height );
	    this.setWidth( width );
	    this.setColor( color );
	    this.setFilled( isFilled );
	    this.setStart( start );
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getHeight() {
		return height;
	}

	public void setHeigth(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void draw() {
		System.out.println("Oval : Start : " + start + " Width : " + width
				+ " Height : " + height + " kleur : " + color + " filled : "
				+ filled);
	}
	
	public void draw( Graphics g )
	{
	    g.setColor( this.color );
	    
	    if ( !filled )
	    {
		    g.drawOval( this.getStart().x, this.getStart().y, this.getWidth(), this.getHeight() );
	    }
	    else
	    {
		    g.fillOval( this.getStart().x, this.getStart().y, this.getWidth(), this.getHeight() );
	    }
	}
}