package com.marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test class for Rover.
 * 
 * @author Shiva
 */
public class RoverTest {

	/**
	 * +VE:  function Init rover with x, y and orientation
	 */
	@Test
	public void initRover() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		assertEquals(x, rover.getPosition().getX());
		assertEquals(y, rover.getPosition().getY());
		assertEquals(0, rover.getPosition().getOrientation());
	}

	/**
	 * +VE:  function for Init rover with x(-VE), y(-VE) and orientation
	 */
	@Test
	public void initRoverWithNveValues() throws InvalidCoordinatesException {
		int x = -2;
		int y = -3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		assertEquals(0, Plateau.getLeftco());
		assertEquals(0, Plateau.getBottomco());
		assertEquals(0, rover.getPosition().getOrientation());
	}

	/**
	 * +VE: Orientiion  Init rover with x > Plateau.getLeft(), y > Plateau.getRight()
	 */
	@Test
	public void initRoverWithPveValues() throws InvalidCoordinatesException {
		int x = 7;
		int y = 8;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		assertEquals(Plateau.getTopco(), rover.getPosition().getY());
		assertEquals(Plateau.getRightco(), rover.getPosition().getX());
		assertEquals(0, Plateau.getBottomco());
		assertEquals(0, Plateau.getLeftco());
	}

	/**
	 * -VE: wrong orientation  with Init rover
	 * 
	 * @throws InvalidCoordinatesException
	 */
	@Test(expected = InvalidCoordinatesException.class)
	public void initRoverWithInvalidOrientation() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		String orientation = "X"; // Wrong orientation
		Plateau.TopRightCoordinatesset(5, 5);
		new Rover(x, y, orientation);
		fail("Test initRoverWithInvalidOrientation() failed!");
	}

	/**
	 * +VE: rover count test
	 */
	@Test
	public void getRoversCount() throws InvalidCoordinatesException {
		int initialCount = Rover.getRoversCount();
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		new Rover(x, y, Constants.SOUTH);
		assertTrue(initialCount + 1 == Rover.getRoversCount());
		new Rover(x, y, Constants.SOUTH);
		assertTrue(initialCount + 2 == Rover.getRoversCount());
	}

	/**
	 * +VE: Test for turnLeft
	 */
	@Test
	public void turnLeft() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		rover.turnLeft();
		assertEquals(Constants.WEST, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE: Test for turnLeft 4 times, it should remains in same direction
	 */
	@Test
	public void turnLeft4Times() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		rover.turnLeft();
		rover.turnLeft();
		rover.turnLeft();
		rover.turnLeft();
		assertEquals(Constants.NORTH, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE: Test for turnRight
	 */
	@Test
	public void turnRight() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.EAST);
		rover.turnRight();
		assertEquals(Constants.SOUTH, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE: Test for turnRight 4 times, it should remains in same direction
	 */
	@Test
	public void turnRight4Times() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		rover.turnRight();
		rover.turnRight();
		rover.turnRight();
		rover.turnRight();
		assertEquals(Constants.NORTH, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE: Test for rover to move a step forward
	 */
	@Test
	public void moveForward() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		rover.moveForward();
		assertEquals(y + 1, rover.getPosition().getY());
		assertEquals(Constants.NORTH, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE:  Pateau's boundary
	 */
	@Test
	public void moveForwardBeyondBoundary() throws InvalidCoordinatesException {
		int x = 2;
		int y = 3;
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		rover.moveForward(); // y = 4
		rover.moveForward(); // y = 5
		rover.moveForward(); // y = 5
		rover.moveForward(); // y = 5
		assertEquals(Plateau.getTopco(), rover.getPosition().getY());
		assertEquals(Constants.NORTH, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE: Test rover to navigate. A full test
	 */
	@Test
	public void navigateRover() throws InvalidCoordinatesException {
		int x = 1;
		int y = 2;
		final String commands = "LMLMLMLMM";
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.NORTH);
		rover.setCommands(commands);
		rover.startNavigation();
		assertEquals(1, rover.getPosition().getX());
		assertEquals(3, rover.getPosition().getY());
		assertEquals(Constants.NORTH, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

	/**
	 * +VE: A full test coverage
	 *
	 */
	@Test
	public void navigateRoverTest2() throws InvalidCoordinatesException {
		int x = 3;
		int y = 3;
		final String commands = "MMRMMRMRRM";
		Plateau.TopRightCoordinatesset(5, 5);
		Rover rover = new Rover(x, y, Constants.EAST);
		rover.setCommands(commands);
		rover.startNavigation();
		assertEquals(5, rover.getPosition().getX());
		assertEquals(1, rover.getPosition().getY());
		assertEquals(Constants.EAST, Constants.CARDINAL_POINTS[rover.getPosition().getOrientation()]);
	}

}
