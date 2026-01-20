package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class Lifeguards {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("java/src/input/lifeguards.in"));
            out = new PrintWriter(new FileWriter("java/src/output/lifeguards.out"));
        } else {
            br = new BufferedReader(new FileReader("lifeguards.in"));
            out = new PrintWriter(new FileWriter("lifeguards.out"));
        }
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // create int[1000] to store intervals
        int[] intervals = new int[1001];
        // create shift class and store shifts in an arr
        Shift[] shifts = new Shift[N];
        // read in and increment int[i]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            shifts[i] = new Shift(start, end);
            for (int j = start; j < end; j++) {
                intervals[j]++;
            }
        }
        int max = 0;
        // iterate over each shift
        for (int i = 0; i < N; i++) {
            int curr = 0;
            for (int j = 1; j <= 1000; j++) {
                boolean withinCurrentShift = j >= shifts[i].start && j < shifts[i].end;
                int interval = withinCurrentShift ? intervals[j] - 1 : intervals[j];
                if (interval > 0)
                    curr++;
            }
            max = Math.max(max, curr);
        }
        out.println(max);

        br.close();
        out.flush();
        out.close();
    }

    static class Shift {
        int start;
        int end;

        public Shift(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
