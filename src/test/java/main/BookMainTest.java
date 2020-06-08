package main;

import java.io.IOException;
import org.junit.Test;


public class BookMainTest {
	
	  @Test
	  public void testMain() throws IOException {
	      String[] args = null;
	      BookMain.main(args);
	  }
	
	  @Test
	  public void testBookMain() throws IOException  {
	      BookMain bookMain = new BookMain();
	  }

	  @Test
	  public void testOpenMain() throws IOException    {

		  BookMain.openMain();    
	  }
	

}
