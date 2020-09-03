package com.marsrover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Mars rover's main class.
 * 
 * @author Shiva
 */
public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	/**
	 * Method loads input file, parses line-by-line. By reading first line of
	 * the input it sets pleatu's upper-right coordinates. Success pair of lines
	 * initialize rover's position and commands to navigate.
	 * 
	 * @param inputFile
	 * @return List<Rover>
	 */
	@SuppressWarnings("resource")
	public List<Rover> initRovers(final String inputFile) throws MarsRoverInputException {
		BufferedReader br = null;
		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = null;
		try {
			br = new BufferedReader(new FileReader(inputFile));
			String line;
			int lineNo = 0;
			String[] tokens = {};
			while ((line = br.readLine()) != null) {
				++lineNo;
				// Initialize plateau's both top and right co-ordinates
				if (lineNo == 1) {
					PlateauCoordinatesset(line);
				} else if (lineNo % 2 == 0) {
					// Initialize plateau's landing position
					tokens = line.split(Constants.SPACE);
					if (tokens.length != 3) {
						throw new MarsRoverInputException("Invalid landing position:\'" + line + "\' received!");
					}
					int x = Integer.parseInt(tokens[0]);
					int y = Integer.parseInt(tokens[1]);
					String orientation = tokens[2];
					rover = new Rover(x, y, orientation);
				} else {
					// Set navigation commands
					rover.setCommands(line);
					roverList.add(rover);
				}
			}
		} catch (FileNotFoundException fnf) {
			throw new MarsRoverInputException("Unable to locate the input file:" + inputFile + ", Error:", fnf);
		} catch (IOException ioe) {
			throw new MarsRoverInputException("Error in reading input file:" + inputFile + ", Error:", ioe);
		} catch (MarsRoverInputException mrie) {
			throw new MarsRoverInputException(mrie);
		} finally {
			Util.BufferedReaderclose(br);
		}
		return roverList;
	}

	/**
	 * Method parses and sets top & right co-ordinates of plateau.
	 * 
	 * @param line
	 */
	private void PlateauCoordinatesset(final String line) throws InvalidCoordinatesException {
		String[] tokens;
		tokens = line.split(Constants.SPACE);
		if (tokens.length != 2) {
			throw new InvalidCoordinatesException("Please give plateau's both top and right co-ordinates");
		}
		int top = Integer.parseInt(tokens[0]);
		int right = Integer.parseInt(tokens[1]);
		Plateau.TopRightCoordinatesset(top, right);
	}

	/**
	 * Method navigates list of rovers one-by-one and displays initial and final
	 * position
	 * 
	 * @param roverList
	 */
	public void Roversnavigate(List<Rover> roverList) {
		for (Rover rover : roverList) {
			rover.displayPosition("INITIAL");
			rover.startNavigation();
			rover.displayPosition("FINAL");
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Invalid input received!");
			System.out.println("Usage: java " + Main.class.getSimpleName() + " <input-file>");
		} else {
			Main main = new Main();
			List<Rover> roverList = null;
			try {
				roverList = main.initRovers(args[0]);
				main.Roversnavigate(roverList);
			} catch (MarsRoverInputException e) {
				LOGGER.error("Error:", e);
			}

		}
	}

}
