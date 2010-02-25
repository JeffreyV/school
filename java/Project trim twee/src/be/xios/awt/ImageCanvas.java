package be.xios.awt;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class ImageCanvas extends Canvas
{
    private Image img;
    
    @Override
    public void paint( Graphics g )
    {
	int x = (this.getSize().width - img.getWidth( null )) /2;
	int y = (this.getSize().height - img.getHeight( null )) /2;
	g.drawImage( img, x, y, null );

        super.paint( g );
    }
    
    public void setImg( Image img )
    {
	this.img = img;
    }
}
