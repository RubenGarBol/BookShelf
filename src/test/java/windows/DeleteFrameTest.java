
package windows;

import org.junit.Test;
import java.io.IOException;

public class DeleteFrameTest{

  @Test
  public void testDeleteFrame() {
      try {
		DeleteFrame deleteFrame = new DeleteFrame();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @Test
  public void testOpenDelete() {

        try {
			DeleteFrame.openDelete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
  }
}
