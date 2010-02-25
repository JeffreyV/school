package be.xios.util;

import java.awt.Color;

public class ColorUtils 
{
	public static Color randomColor()
	{
		return new Color(
				(int)(Math.random() * 256),
				(int)(Math.random() * 256),
				(int)(Math.random() * 256));
	}
}
