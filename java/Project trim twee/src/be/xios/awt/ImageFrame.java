package be.xios.awt;

import java.awt.Image;

import javax.imageio.ImageIO;

public class ImageFrame extends ClosableFrame
{
    private Image images[];
    
    public static void main( String[] args )
    {
	new ImageFrame();
    }
    
    public ImageFrame()
    {
	images = new Image[6];
	
    }
}
