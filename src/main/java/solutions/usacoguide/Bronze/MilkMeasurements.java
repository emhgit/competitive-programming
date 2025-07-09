package solutions.usacoguide.Bronze;

import java.util.*;
import java.io.*;

public class MilkMeasurements {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/measurement.in"));
            out = new PrintWriter(new FileWriter("src/output/measurement.out"));
        } else {
            br = new BufferedReader(new FileReader("measurement.in"));
            out = new PrintWriter(new FileWriter("measurement.out"));
        }
    }
}
