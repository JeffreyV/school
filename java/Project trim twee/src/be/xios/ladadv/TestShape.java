package be.xios.ladadv;

import java.awt.Point;
import java.lang.reflect.Field;

import be.xios.graphics.ShapeA;
import be.xios.util.ColorUtils;

public class TestShape 
{
	private static ShapeA shape1;
	private static ShapeA shape2;
	
	public static void main(String[] args) 
	{
		shape1 = new ShapeA();
		shape2 = new ShapeA();
		
		shape1.setStart( new Point(50,30) );
		shape2.setStart( new Point(30,80) );		
		shape1.setColor( ColorUtils.randomColor() );
		shape2.setColor( ColorUtils.randomColor() );
		
		System.out.println( shape1 );
		System.out.println( shape2 );
		
	}
}
