package be.xios.awt;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Panel;

public class SuperPanel extends Panel
{

    public SuperPanel()
    {
	super();
	// TODO Auto-generated constructor stub
    }

    public SuperPanel( LayoutManager layout )
    {
	super( layout );
	// TODO Auto-generated constructor stub
    }

    public void add_multi( Component... comps )
    {
	for (Component comp : comps)
	{
	    super.add( comp );
	}
    }
}
