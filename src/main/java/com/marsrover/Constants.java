package com.marsrover;

import java.util.HashMap;
import java.util.Map;

/**
 * Commonly used constants.
 * 
 * @author Shiva
 */
public final class Constants {

	static final String SPACE = " ";
	static final String EAST = "E";
	static final String WEST = "W";
	static final String NORTH = "N";
	static final String SOUTH = "S";
	
	static final String[] CARDINAL_POINTS = { Constants.NORTH,
		Constants.EAST, Constants.SOUTH, Constants.WEST };
	
	static final int CARDINAL_POINTS_COUNT = CARDINAL_POINTS.length;
	
	static final Map<String, Integer> CARDINAL_POINTS_MAP = new HashMap<String, Integer>(); 
	
	static {
		for(int i=0; i<CARDINAL_POINTS.length;i++) {
			CARDINAL_POINTS_MAP.put(CARDINAL_POINTS[i], i);
		}
	}
}
