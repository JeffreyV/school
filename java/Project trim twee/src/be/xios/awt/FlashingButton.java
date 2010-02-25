package be.xios.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.HeadlessException;

public class FlashingButton extends Button
{
    private Button me;
    private int    sleep_time;

    public FlashingButton( int time ) throws HeadlessException
    {
	super();
	me = this;
	this.sleep_time = time;
	addFlash();
    }

    public FlashingButton( String label, int time ) throws HeadlessException
    {
	super( label );
	me = this;
	this.sleep_time = time;
	addFlash();
    }

    private void addFlash()
    {
	new Thread( new Runnable()
	{

	    @Override
	    public void run()
	    {
		while (true)
		{
		    me.setBackground( new Color( (int) (Math.random() * 256),
			    (int) (Math.random() * 256),
			    (int) (Math.random() * 256) ) );

		    try
		    {
			Thread.sleep( sleep_time );
		    }
		    catch (Exception e)
		    {
			// TODO: handle exception
		    }
		}

	    }
	} ).start();
    }
}
