package com.marsrover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Test case execution class
 * 
 * @author Shiva
 */
public class MainTest {

	/**
	 * +VE: Test for   navigation , set plateau's co-ordinate parse input, s, create rovers and

	 */
	@Test
	public void initRovers() throws MarsRoverInputException {
		Main main = new Main();
		final String inputFile = "src/test/resources/input.txt";
		List<Rover> roverList = main.initRovers(inputFile);
		assertEquals(5, Plateau.getTopco());
		assertEquals(5, Plateau.getRightco());
		System.out.println("Size:" + roverList.size());
		assertTrue(roverList.size() == 2);
		main.Roversnavigate(roverList);
	}

	/**
	 * -VE: Test for  invalid plateau top/right
	 */
	@Test(expected = MarsRoverInputException.class)
	public void initRoverswithInvalidPlateauTopRightInput() throws MarsRoverInputException {
		final String inputFile = "src/test/resources/invalid-plateau-top-right-input.txt";
		new Main().initRovers(inputFile);
	}

	/**
	 * -VE:  Test for the Invalid rover landing position input
	 */
	@Test(expected = MarsRoverInputException.class)
	public void initRoverswithInvliadRoverPositonInput() throws MarsRoverInputException {
		final String inputFile = "src/test/resources/invalid-rover-position-input.txt";
		new Main().initRovers(inputFile);
	}

	/**
	 * -VE:  Test for the Invalid input file path
	 */
	@Test(expected = MarsRoverInputException.class)
	public void initRoverswithInputFileNotExists() throws MarsRoverInputException {
		final String inputFile = "src/test/resources/file-doesnt-exists.txt";
		new Main().initRovers(inputFile);
	}
	
}
