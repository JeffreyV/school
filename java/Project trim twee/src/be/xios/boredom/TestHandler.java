package be.xios.boredom;

import java.io.File;
import static be.xios.boredom.FileHandler.*;

public class TestHandler
{
    public static void main( String[] args )
    {
	File my_file = new File("/home/student/Documents/data/array.txt");
	Reader r = newReader( my_file );
	r.print_content();
    }
}
