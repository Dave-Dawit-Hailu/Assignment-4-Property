
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents Student test cases for a Property object.
 *
 * @author Dave| Dawit Hailu
 * @version 4/10/2024
 */
class PropertyTestStudent {
	Property propertyOne;
	
	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property DFT", "Silver Spring", 3500.00, "Capital One Bank");
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property DFT", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(3500.00, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property DFT,Silver Spring,Capital One Bank,3500.0", propertyOne.toString());	
	}

}
