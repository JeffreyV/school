package be.xios.graphics;

import java.awt.Color;
import java.awt.Point;

public class ShapeA 
{
	protected Point start;
	protected Color color;
	
	public ShapeA()
	{
		
	}
	
	public void draw()
	{
		System.out.println("Rendering van figuren");
	}
	
	public void setStart( Point start )
	{
		this.start = start;
	}
	
	public Point getStart()
	{
		return new Point( this.start.x,
						  this.start.y);
	}

	public Color getColor() 
	{
		return color;
	}

	public void setColor(Color color) 
	{
		this.color = color;
	}
	
	@Override
	public String toString()
	{
		return String.format(
				"Shape: coordinate (%d, %d) kleur: %s", 
				this.start.x,
				this.start.y,
				this.color);
	}
}
