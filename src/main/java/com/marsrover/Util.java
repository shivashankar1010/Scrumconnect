package com.marsrover;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * A utility class.
 * 
 * @author shiva
 */
public class Util {

	private static final Logger LOGGER = Logger.getLogger(Util.class);

	/**
	 * Method used to close buffered reader's instance.
	 * 
	 * @param br
	 */
	public static void BufferedReaderclose(BufferedReader br) {
		try {
			if (br != null)
				br.close();
		} catch (IOException e) {
			LOGGER.error("Error while closing buffered reader instance");
		}
	}

}
