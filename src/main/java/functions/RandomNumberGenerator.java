package main.java.functions;

import main.java.interfaces.RandomGenerator;

import java.util.Random;

public class RandomNumberGenerator implements RandomGenerator {

    @Override
    public int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(lowerBound, upperBound+1);
    }
}
