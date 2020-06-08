
package windows;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;

import models.Book;

public class DescriptionPanelTest  {

  Book book; 
  
  @Before
  public void setUp() {
	  book = new Book();
	  book.setCover("https://ep01.epimg.net/cultura/imagenes/2018/08/15/babelia/1534351691_997591_1534352892_noticia_normal.jpg");
  }
  @Test
  public void testImage(){
      Image image0 = DescriptionPanel.getScaledImage((Image) null, 1133, 1133);
      BufferedImage bufferedImage0 = (BufferedImage)DescriptionPanel.getScaledImage(image0, 1133, 368);
      assertEquals(2, bufferedImage0.getType());
      assertEquals(368, bufferedImage0.getHeight());
      assertEquals(1133, bufferedImage0.getWidth());
  }

  @Test
  public void testFrame()  {
	  DescriptionPanel mockDescription = new DescriptionPanel(book);
    
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testFrameFail()  {
	  book.setCover("Texto plano"); 
	  DescriptionPanel mockFailDescription = new DescriptionPanel(book);
 
  }

}
