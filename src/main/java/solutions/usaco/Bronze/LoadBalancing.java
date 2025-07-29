package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class LoadBalancing {
    static Point[] points;
    static Set<Integer> xSet, ySet;
    static int N, B;

    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/balancing.in"));
            out = new PrintWriter(new FileWriter("src/output/balancing.out"));
        } else {
            br = new BufferedReader(new FileReader("balancing.in"));
            out = new PrintWriter(new FileWriter("balancing.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        points = new Point[N];
        xSet = new HashSet<>();
        ySet = new HashSet<>();
        // read in and store points in an arr
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            xSet.add(x);
            int y = Integer.parseInt(st.nextToken());
            ySet.add(y);
            points[i] = new Point(x, y);
        }

        // add x and y to sets
        // iterate over x
        int min = Integer.MAX_VALUE;
        for (int x : xSet) {
            for (int y : ySet) {
                int max1 = calculateMax(x, y, 1, 1);
                int max2 = calculateMax(x, y, 1, -1);
                int max3 = calculateMax(x, y, -1, 1);
                int max4 = calculateMax(x, y, -1, -1);
                min = Math.min(min, Math.min(Math.min(max1, max2), Math.min(max3, max4)));
            }
        }
        out.println(min);
        // iterate over y
        // set a plus one and minus one and set max
        // print max

        br.close();
        out.flush();
        out.close();
    }

    static int calculateMax(int x, int y, int j, int k) {
        int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
        for (int i = 0; i < N; i++) {
            if (points[i].x < x + j && points[i].y > y + k) {
                q1++;
            } else if (points[i].x > x + j && points[i].y > y + k) {
                q2++;
            } else if (points[i].x < x + j && points[i].y < y + k) {
                q3++;
            } else if (points[i].x > x + j && points[i].y < y + k) {
                q4++;
            }
        }
        int max = Math.max(Math.max(q1, q2), Math.max(q3, q4));
        return max;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
