package solutions.usacoguide.Bronze;

import java.io.*;
import java.util.*;

// fix this implementation 

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

        int[] bessie = new int[101];
        int[] elsie = new int[101];
        int[] mildred = new int[101];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            String cow = st.nextToken();
            int delta = Integer.parseInt(st.nextToken());
            switch (cow) {
                case "Bessie":
                    bessie[day] = delta;
                    break;
                case "Elsie":
                    elsie[day] = delta;
                    break;
                case "Mildred":
                    mildred[day] = delta;
                    break;
            }
        }

        int bessieCurr = 7, elsieCurr = 7, mildredCurr = 7;
        int highest = 7, changes = 0;
        int highestCow = 0;
        for (int i = 0; i < 101; i++) {
            int currHighestCow = 0;
            bessieCurr += bessie[i];
            elsieCurr += elsie[i];
            mildredCurr += mildred[i];
            highest = Math.max(bessieCurr, Math.max(elsieCurr, mildredCurr));
            boolean bessieHighest = bessieCurr >= elsieCurr && bessieCurr >= mildredCurr && bessieCurr >= highest;
            boolean elsieHighest = elsieCurr >= bessieCurr && elsieCurr >= mildredCurr && elsieCurr >= highest;
            boolean mildredHighest = mildredCurr >= bessieCurr && mildredCurr >= elsieCurr && mildredCurr >= highest;

            if ((bessie[i] > 0 && bessieHighest && highestCow == 0)
                    || (bessieHighest && highestCow != 0 && highestCow != 1 && (elsie[i] != 0 && mildred[i] != 0)
                            || bessie[i] > 0))
                currHighestCow = 1;
            else if ((elsie[i] > 0 && elsieHighest && highestCow == 0)
                    || (elsieHighest && highestCow != 0 && highestCow != 2 && (bessie[i] != 0 && mildred[i] != 0)
                            || elsie[i] > 0))
                currHighestCow = 2;
            else if ((mildred[i] > 0 && mildredHighest && highestCow == 0)
                    || (mildredHighest && highestCow != 0 && highestCow != 3 && (elsie[i] != 0 && bessie[i] != 0)
                            || mildred[i] > 0))
                currHighestCow = 3;

            if (currHighestCow == 1 && highestCow != 1) {
                highestCow = 1;
                highest = bessieCurr;
                changes++;
                System.out.println("bessie is the new highest at day " + i + ", " + changes + " changes" + " new high: "
                        + highest);
            } else if (currHighestCow == 2 && highestCow != 2) {
                highestCow = 2;
                highest = elsieCurr;
                changes++;
                System.out.println("elsie is the new highest at day " + i + ", " + changes + " changes" + " new high: "
                        + highest);
            } else if (currHighestCow == 3 && highestCow != 3) {
                highestCow = 3;
                highest = mildredCurr;
                changes++;
                System.out
                        .println("mildred is the new highest at day " + i + ", " + changes + " changes" + " new high: "
                                + highest);
            }
        }

        out.println(changes);

        br.close();
        out.flush();
        out.close();
    }
}