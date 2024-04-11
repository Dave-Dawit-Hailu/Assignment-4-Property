
/**
 * This class represents Student test cases for a ManagementCompany object.
 * 
 * @author Dave| Dawit Hailu
 * @version 4/10/2024
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Kings", "999999999",7);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("KingsMen", "Darwin", 3500, "Baby Dave",2,5,3,3);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("KingsMen", "Darwin", 3500, "Baby Dave",2,5,3,3);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property ("KingsMen", "Darwin", 3500, "Baby Dave",2,5,3,3);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Kings, taxID: 999999999\n"
				+ "______________________________________________________\n"
				+ "KingsMen,Darwin,Baby Dave,3500.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ "total management Fee: 245.00";
		System.out.println(expectedString);
		System.out.println(mangementCo.toString());
		assertEquals(expectedString, mangementCo.toString());
				
	}

}
