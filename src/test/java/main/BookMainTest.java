package main;

import java.io.IOException;
import org.junit.Test;


public class BookMainTest {
	
	  @Test
	  public void testMain() {
	      String[] args = null;
	      BookMain.main(args);
	  }
	
	  @Test
	  public void testBookMain() {
	      try {
			BookMain bookMain = new BookMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  @Test
	  public void testOpenMain() {

		  try {
			BookMain.openMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	  }
	

}
