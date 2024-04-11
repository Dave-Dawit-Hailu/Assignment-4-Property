
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents Student test cases for a Plot object.
 * 
 * @author Dave| Dawit Hailu
 * @version 4/10/2024
 * 
 */
public class PlotTestStudent {
	private Plot plot1, plot5;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(1, 1, 5, 5);
		plot5 = new Plot(2, 2, 4, 3);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
	}
	
	@Test
	public void testToString() {
		assertEquals("2,2,4,3",plot5.toString());	
	}

}
