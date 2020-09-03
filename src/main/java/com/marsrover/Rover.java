package com.marsrover;

import org.apache.log4j.Logger;

/**
 * Holds rover's state and its behaviours
 * 
 * @author Shiva
 */
public class Rover {

	private static final Logger LOGGER = Logger.getLogger(Rover.class);

	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final char MOVE = 'M';

	private Position pos;
	private String commands;
	private int id;

	private static int count;

	/**
	 * Constructor to initialize rover's position.
	 * 
	 * @param x
	 * @param y
	 * @param orientation
	 * @throws InvalidCoordinatesException 
	 */
	public Rover(int x, int y, String orientation) throws InvalidCoordinatesException {
		int givenX = x, givenY = y;

		if (x > Plateau.getRightco()) {
			x = Plateau.getRightco();
		}
		if (y > Plateau.getTopco()) {
			y = Plateau.getTopco();
		}
		if (x < Plateau.getLeftco()) {
			x = Plateau.getLeftco();
		}
		if (y < Plateau.getBottomco()) {
			y = Plateau.getBottomco();
		}

		
		if (givenX != x || givenY != y) {
			LOGGER.warn("Couldn't deploy a rover at position(" + givenX + ", " + givenY + "). Positioning at(" + x + ", " + y + ")");
		}

		Integer iOrientation = Constants.CARDINAL_POINTS_MAP.get(orientation);
		if(iOrientation == null)
			throw new InvalidCoordinatesException("Invalid orientation \'" + orientation + "\'");
		
		pos = new Position(x, y, Constants.CARDINAL_POINTS_MAP.get(orientation));
		id = ++count;
	}
	
	/**
	 * Returns rover's count.
	 * 
	 * @return int
	 */
	public static int getRoversCount() {
		return count;
	}
	
	/**
	 * Returns rover's id.
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns rover's current position.
	 * 
	 * @return Position
	 */
	public Position getPosition() {
		return pos;
	}

	/**
	 * Sets rover's navigation commands.
	 * 
	 * @param commands
	 */
	public void setCommands(final String commands) {
		this.commands = commands;
	}

	/**
	 * Returns rover's navigation commands.
	 * 
	 * @return commands
	 */
	public String getCommands() {
		return commands;
	}

	/**
	 * Method to turn rover left from its current direction.
	 */
	public void turnLeft() {
		int left = ((pos.getOrientation() == 0) ? Constants.CARDINAL_POINTS_COUNT : pos.getOrientation()) - 1;
		LOGGER.info("R[" + id + "] LEFT(" + Constants.CARDINAL_POINTS[pos.getOrientation()] + ") -> " + Constants.CARDINAL_POINTS[left]);
		pos.setOrientation(left);
	}

	/**
	 * Method to turn rover right from its current direction.
	 */
	public void turnRight() {
		int right = (pos.getOrientation() + 1) % Constants.CARDINAL_POINTS_COUNT;
		LOGGER.info("R[" + id + "] RIGHT(" + Constants.CARDINAL_POINTS[pos.getOrientation()] + ") -> " + Constants.CARDINAL_POINTS[right]);
		pos.setOrientation(right);
	}

	/**
	 * Method to move rover one step forward.
	 */
	public void moveForward() {
		LOGGER.info("R[" + id + "] MOVE FWD");
		switch (Constants.CARDINAL_POINTS[pos.getOrientation()]) {
		case Constants.NORTH:
			if (pos.getY() < Plateau.getTopco()) {
				pos.setY(pos.getY() + 1);
			}
			break;
		case Constants.EAST:
			if (pos.getX() < Plateau.getRightco()) {
				pos.setX(pos.getX() + 1);
			}
			break;
		case Constants.SOUTH:
			if (pos.getY() > Plateau.getBottomco()) {
				pos.setY(pos.getY() - 1);
			}
			break;
		case Constants.WEST:
			if (pos.getX() > Plateau.getLeftco()) {
				pos.setX(pos.getX() - 1);
			}
			break;
		}
	}

	/**
	 * Method to navigate rover either left or right, or move forward.
	 */
	public void startNavigation() {
		for (char command : getCommands().toCharArray()) {
			if (command == LEFT)
				turnLeft();
			else if (command == RIGHT)
				turnRight();
			else if (command == MOVE)
				moveForward();
		}
	}

	/**
	 * Display rover's initial or final position.
	 * 
	 * @param prefix
	 */
	public void displayPosition(final String prefix) {
		LOGGER.info("R[" + id + "] " + prefix + " POSITION X:" + pos.getX() + " Y:" + pos.getY() + " DIRECTION:"
				+ Constants.CARDINAL_POINTS[pos.getOrientation()]);
	}

}
