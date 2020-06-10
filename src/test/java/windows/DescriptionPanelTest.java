
package windows;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

import static org.junit.Assert.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import models.Book;

public class DescriptionPanelTest  {

  Book book; 
  
  /*
 
*/

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
  
  
 

}
