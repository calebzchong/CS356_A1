package edu.cpp.cs356.assignment1;

import java.math.BigInteger;
import java.util.Random;

public class IDGenerator {
	private static Random random = new Random();
	
    public static String getRandomID(int numChars) {
        return new BigInteger(numChars*5, random).toString(32);
    }
}
