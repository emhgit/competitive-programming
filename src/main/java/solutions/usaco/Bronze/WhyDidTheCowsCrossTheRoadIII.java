package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class WhyDidTheCowsCrossTheRoadIII {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/cowqueue.in"));
            out = new PrintWriter(new FileWriter("src/output/cowqueue.out"));
        } else {
            br = new BufferedReader(new FileReader("cowqueue.in"));
            out = new PrintWriter(new FileWriter("cowqueue.out"));
        }

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(start, duration);
        }
        Arrays.sort(cows, (c1, c2) -> Integer.compare(c1.start, c2.start));
        int time = 0;
        for (int i = 0; i < N; i++) {
            time = cows[i].start > time ? time + cows[i].start - time + cows[i].duration : time + cows[i].duration;
        }
        out.println(time);

        br.close();
        out.flush();
        out.close();
    }

    static class Cow {
        int start;
        int duration;

        public Cow(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
}