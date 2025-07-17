package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/measurement.in"));
            out = new PrintWriter(new FileWriter("src/output/measurement.out"));
        } else {
            br = new BufferedReader(new FileReader("measurement.in"));
            out = new PrintWriter(new FileWriter("measurement.out"));
        }

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Measurement[] measurements = new Measurement[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cow;
            switch (st.nextToken()) {
                case "Bessie":
                    cow = 0;
                    break;
                case "Elsie":
                    cow = 1;
                    break;
                case "Mildred":
                    cow = 2;
                    break;
                default:
                    cow = 0;
            }
            int delta = Integer.parseInt(st.nextToken());
            measurements[i] = new Measurement(day, delta, cow);
        }
        Arrays.sort(measurements, (m1, m2) -> Integer.compare(m1.day, m2.day));

        int[] cows = { 7, 7, 7 };
        String[] cowNames = { "Bessie", "Elsie", "Mildred" };
        Set<String> display = new HashSet<>(Arrays.asList(cowNames));
        Set<String> prevDisplay;
        int changes = 0;
        for (Measurement measurement : measurements) {
            prevDisplay = new HashSet<>(display);
            cows[measurement.cow] += measurement.delta;
            int max = Math.max(cows[0], Math.max(cows[1], cows[2]));

            display.clear();
            for (int i = 0; i < 3; i++) {
                if (cows[i] == max)
                    display.add(cowNames[i]);
            }

            if (!prevDisplay.equals(display))
                changes++;
        }

        out.println(changes);

        br.close();
        out.flush();
        out.close();
    }

    static class Measurement {
        int day;
        int delta;
        int cow;

        public Measurement(int day, int delta, int cow) {
            this.day = day;
            this.delta = delta;
            this.cow = cow;
        }
    }
}