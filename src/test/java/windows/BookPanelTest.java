
package windows;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import models.Book;

public class BookPanelTest {
	
  private Book book;
  @Before 
  public void setUp() {
	  book = new Book();
	  book.setCover("https://ep01.epimg.net/cultura/imagenes/2018/08/15/babelia/1534351691_997591_1534352892_noticia_normal.jpg");
  }
  
  
  @Test
  public void testBookPanel() throws IOException   {
		BookPanel bookPanel =  new BookPanel(book);
	
	}
       
}

  