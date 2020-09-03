package com.marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test class for Plateau.
 *  
 * @author Shiva
 */
public class PlateauTest {

	/**
	 * +VE:  test for  Set top & right coordinates
	 */
	@Test
	public void setTopRightCoordinates() {
		try {
			int top = 5;
			int right = 6;
			Plateau.TopRightCoordinatesset(top, right);
			assertEquals(top, Plateau.getTopco());
			assertEquals(right, Plateau.getRightco());
			assertEquals(0, Plateau.getBottomco());
			assertEquals(0, Plateau.getLeftco());
		} catch (InvalidCoordinatesException e) {
			e.printStackTrace();
			fail("Test setTopRightCoordinates() failed!");
		}
	}

	/**
	 * +VE:  setting up top & right coordinates with 0, 0 respectively
	 */
	@Test
	public void setTopRightCoordinatesWithBothZero() {
		try {
			Plateau.TopRightCoordinatesset(0, 0);
		} catch (InvalidCoordinatesException e) {
			e.printStackTrace();
			fail("Test setTopRightCoordinatesWithBothZero() failed!");
		}
	}

	/**
	 * -VE: Setting of  top & right coordinates with top  less than  0
	 */
	@Test(expected = InvalidCoordinatesException.class)
	public void setTopRightCoordinatesWithTopLtZero() throws InvalidCoordinatesException{
		Plateau.TopRightCoordinatesset(-3, 5);
		fail("Test setTopRightCoordinatesWithTopLtZero() failed!");
	}

	/**
	 * -VE: Settting of  top & right coordinates with right < 0
	 */
	@Test(expected = InvalidCoordinatesException.class)
	public void setTopRightCoordinatesWithRighLtZero() throws InvalidCoordinatesException{
		Plateau.TopRightCoordinatesset(3, -5);
		fail("Test setTopRightCoordinatesWithRighLtZero() failed!");
	}

}
