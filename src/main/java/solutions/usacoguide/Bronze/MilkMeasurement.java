package solutions.usacoguide.Bronze;

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
        int[] bessie = new int[101];
        int[] elsie = new int[101];
        int[] mildred = new int[101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            String cow = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            switch (cow) {
                case "Bessie":
                    bessie[day] = change;
                    break;
                case "Elsie":
                    elsie[day] = change;
                    break;
                case "Mildred":
                    mildred[day] = change;
                    break;
            }
        }

        int bessieTotal = 7, elsieTotal = 7, mildredTotal = 7;
        int max = 7;
        int change = 0;
        for (int i = 0; i < 101; i++) {
            bessieTotal += bessie[i];
            elsieTotal += elsie[i];
            mildredTotal += mildred[i];

            if (bessieTotal > max || elsieTotal > max || mildredTotal > max) {
                boolean bessieIsHighest = bessieTotal > elsieTotal && bessieTotal > mildredTotal;
                boolean elsieIsHighest = elsieTotal > bessieTotal && elsieTotal > mildredTotal;
                boolean mildredIsHighest = mildredTotal > bessieTotal && mildredTotal > elsieTotal;

                if (bessieIsHighest || elsieIsHighest || mildredIsHighest)
                    change++;

            } else if (bessieTotal == max || elsieTotal == max || mildredTotal == max) {

            }
        }

        br.close();
        out.flush();
        out.close();
    }
}