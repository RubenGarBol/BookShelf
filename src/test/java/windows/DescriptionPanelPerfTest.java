
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


public class DescriptionPanelPerfTest  {

  
  @Rule
  public ContiPerfRule rule = new ContiPerfRule();
  

  
  @Test
  @PerfTest(threads = 4, duration = 3000, warmUp = 1500)
  @Required(max = 500, average = 250, percentile95 = 350, throughput = 10)
  public void testImagePerf(){
	  Image image1 = DescriptionPanel.getScaledImage((Image) null, 1133, 1133);
      BufferedImage bufferedImage1 = (BufferedImage)DescriptionPanel.getScaledImage(image1, 1133, 368);
      assertEquals(2, bufferedImage1.getType());
      assertEquals(368, bufferedImage1.getHeight());
      assertEquals(1133, bufferedImage1.getWidth());
  }
 

}
