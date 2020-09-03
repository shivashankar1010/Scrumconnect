package com.marsrover;

/**
 * Holds state of rover's position.
 * 
 * @author Shiva
 */
public class Position {

	/**	Position in horizantal - X */
	private int x;
	
	/**	Position in vertical - Y */
	private int y;
	
	/**	Orientation or direction of robot's head, where
	 * 0 - NORTH
	 * 1 - EAST
	 * 2 - SOUTH
	 * 3 - EAST
	 */
	private int orientation;

	/**
	 * A constructor to initialize rover's position.
	 * 
	 * @param x
	 * @param y
	 * @param orientation
	 */
	public Position(int x, int y, int orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	/**
	 * Returns value of x
	 * 
	 * @return int
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets value to x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns value of y
	 * 
	 * @return int
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets value to y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns value of orientation
	 * 
	 * @return int
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * Sets orientation value
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

}
