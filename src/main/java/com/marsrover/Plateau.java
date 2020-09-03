package com.marsrover;

/**
 * Holds rectangular plateau's co-ordinates.
 * 
 * @author Shiva
 */
public class Plateau {

	/**	Top co-ordinate */
	private static int top;
	
	/**	Right co-ordinate */
	private static int right;
	
	/**	Bottom co-ordinate */
	private static final int bottom = 0;
	
	/**	Left co-ordinate */
	private static final int left = 0;
	
	/**
	 * Private to avoid instantiation
	 */
	private Plateau() {}

	/**
	 * Method to set plateau's top-right co-ordinates.
	 * 
	 * @param top
	 * @param right
	 * @throws InvalidCoordinatesException if the given values are -ve
	 */
	public static void TopRightCoordinatesset(int top, int right) throws InvalidCoordinatesException {
		if(top < 0 || right < 0) {
			throw new InvalidCoordinatesException("Invalid co-ordinates(top=" + top + ", right=" + right + "). Requires +VE vaues");
		}
		setTopco(top);
		setRightco(right);
	}

	/**
	 * Returns top co-ordinate
	 * 
	 * @return int
	 */
	public static int getTopco() {
		return top;
	}

	/**
	 * Sets top co-ordinate
	 */
	public static void setTopco(int top) {
		Plateau.top = top;
	}

	/**
	 * Returns right co-ordinate
	 * 
	 * @return int
	 */
	public static int getRightco() {
		return right;
	}

	/**
	 * Sets right co-ordinate
	 */
	public static void setRightco(int right) {
		Plateau.right = right;
	}

	/**
	 * Returns bottom co-ordinate. It is zero always.
	 * 
	 * @return int
	 */
	public static int getBottomco() {
		return bottom;
	}

	/**
	 * Returns left co-ordinate. It is zero always.
	 * 
	 * @return int
	 */
	public static int getLeftco() {
		return left;
	}

}