
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestFrontend {
	
	/** 
	 * Tests to see if the Intersection Input Validation is working as expected
	 * and cleaning up any formatting issues
	 */
	@Test
	public void testInputValidation() {
		String str1 = Frontend.helpTestInputValidation("Liden&Babcock");
		String str2 = Frontend.helpTestInputValidation("liden&babCOck");
		String str3 = Frontend.helpTestInputValidation("LIDEN    &       BABCOCk");
		assertEquals(str1, "Liden & Babcock");
		assertEquals(str2, "Liden & Babcock");
		assertEquals(str3, "Liden & Babcock");
	}
	
	/** 
	 * Tests to see if correct mode is served when given an appropriate character
	 */
	@Test
	public void testSereMode() {
		assertEquals(Frontend.helpTestServeMode('b'), "Base");
		assertEquals(Frontend.helpTestServeMode('a'), "Overview");
		assertEquals(Frontend.helpTestServeMode('c'), "Construction");
	}
	
	/** 
	 * Test if Base mode is function properly with all its functions working (Input Validation, Print Maker, Output) 
	 */
	@Test
	public void testBaseMode() {
		assertEquals(Frontend.helpTestBaseMode("oBservatory& Babcock", "liden&Henry"), 
				"The Shortest Path: Observatory & Babcock, Liden & Babcock, Liden & Henry");
	}
}
