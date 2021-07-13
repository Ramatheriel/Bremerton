package minami.bremerton.test;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import minami.bremerton.zipCode.Bremerton;

/**
* <h1>Zip Codes range simplifier - Bremerton</h1>
* Testing Class
* Simple testing examples for Bremerton.
* <p>
*
* @author  Meneses, Ricardo
* @version 1.2
* @since   2021-07-06
*/

public class BremertonTest {
	
	/**
	 * @param inputString - an example to test the code.
	 */
	String inputString = "[94133,94133] [94200,94299] [94226,94399]";
	
	/**
	 * Tests the complete application.
	 * @param example - a complex example to test the code.
	 */
	@Test
	public final void testMain() {
		String example = "[74251-74320]      [74251-75720] [79832-82514] [82500-85642]  [86789-87900] [89352-90299] [90133-90133]  [91622-92722] [93200-95299] [93833-94133] [93922-94722] [95200-96299] [97133-97133] [97622-97722] [98200-99299]";
		Assert.assertEquals("[[74251-75720], [79832-85642], [86789-87900], [89352-90133], [91622-92722], [93200-94722], [95200-96299], [97133-97133], [97622-97722], [98200-99299]]",  Arrays.toString(Bremerton.showList(Bremerton.reduceRanges(Bremerton.splitZipCodes(Bremerton.validateInput(example))))));
	}

	/**
	 * Tests the core logic of the application.
	 */
	@Test
	public final void testReduceRanges() {		
		Assert.assertEquals("[94133,94133] [94200,94399]", Bremerton.reduceRanges(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))).toString());
	}

	/**
	 * Tests the list convertion method.
	 */
	@Test
	public final void testShowList() {
		Assert.assertEquals("[[94133-94133], [94200-94399]]", Arrays.toString(Bremerton.showList(Bremerton.reduceRanges(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))))));
	}
	
	/**
	 * Tests the application with wrong input parameters.
	 */
	@Test
	public final void testMainFailLetters() {
		Assert.assertEquals("ASDFasfasgfahgsdf", Arrays.toString(Bremerton.showList(Bremerton.reduceRanges(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))))));
	}
	
	/**
	 * Tests the application with empty parameters.
	 */
	@Test
	public final void testMainFailRanges() {
		Assert.assertEquals("[][][][][]", Arrays.toString(Bremerton.showList(Bremerton.reduceRanges(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))))));
	}
	
	/**
	 * Tests the core logic of the application with inverted ranges, should ignore the wrong one.
	 */
	@Test
	public final void testReduceRangesWrongRanges() {
		Assert.assertEquals("[[90234-89002], [94200-94399]]", Bremerton.reduceRanges(Bremerton.splitZipCodes(Bremerton.validateInput(inputString))).toString());
	}
}
