package be.xios.boredom;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class FileHandler implements Reader, Writer
{
    private File m_file;
    
    public FileHandler( File f )
    {
	this.m_file = f;
    }
    
    public static Reader newReader( File f )
    {
	return new FileHandler(f);
    }
    
    @Override
    public void print_content()
    {
	try
	{
	    Scanner sc = new Scanner(new FileInputStream( this.m_file ));
	    
	    String line = null;
	    while ((line = sc.nextLine()) != null )
	    {
		System.out.println( line );
	    }
	    
	    sc.close();
	}
	catch (Exception e)
	{
	    
	}
    }
}
