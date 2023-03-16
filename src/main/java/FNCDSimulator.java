package main.java;
import main.java.helper.FNCDHelper;

import java.io.IOException;

public class FNCDSimulator {
    public static void main(String[] args) throws IOException {
        FNCDHelper fncdHelper = new FNCDHelper();
        fncdHelper.simulate();
    }
}