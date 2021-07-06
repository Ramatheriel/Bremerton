/**
 * 
 */
package minami.bremerton.test;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import minami.bremerton.zipCode.Bremerton;

public class BremertonTest {
	
	Bremerton testBremerton = new Bremerton();
	String inputString = "[94133,94133] [94200,94299] [94226,94399]";

	@Test
	public final void testMain() {
		String example = "[74251-74320]      [74251-75720] [79832-82514] [82500-85642]  [86789-87900] [89352-90299] [90133-90133]  [91622-92722] [93200-95299] [93833-94133] [93922-94722] [95200-96299] [97133-97133] [97622-97722] [98200-99299]";
		Assert.assertEquals("[[74251-75720], [79832-85642], [86789-87900], [89352-90133], [91622-92722], [93200-94722], [95200-96299], [97133-97133], [97622-97722], [98200-99299]]",  Arrays.toString(Bremerton.showList(Bremerton.seekAndDestroy(Bremerton.splitZipCodes(Bremerton.validateInput(example))))));
	}

	@Test
	public final void testSeekAndDestroy() {		
		Assert.assertEquals("[94133,94133] [94200,94399]", Bremerton.seekAndDestroy(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))).toString());
	}

	@Test
	public final void testShowList() {
		Assert.assertEquals("[[94133-94133], [94200-94399]]", Arrays.toString(Bremerton.showList(Bremerton.seekAndDestroy(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))))));
	}
}
