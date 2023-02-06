package functions;

import interfaces.RandomGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements RandomGenerator {

    @Override
    public int generateRandomNumber(int lowerBound, int upperBound) {
        return ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
    }
}
