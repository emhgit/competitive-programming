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
            System.out.println(change);
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

        br.close();
        out.flush();
        out.close();
    }
}