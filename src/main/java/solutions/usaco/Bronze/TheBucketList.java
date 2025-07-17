package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class TheBucketList {
    // Problem URL: https://usaco.org/index.php?page=viewproblem2&cpid=856
    public static void main(String[] args) throws IOException {

        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/blist.in"));
            out = new PrintWriter(new FileWriter("src/output/blist.out"));
        } else {
            br = new BufferedReader(new FileReader("blist.in"));
            out = new PrintWriter(new FileWriter("blist.out"));
        }

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;

        int[] intervals = new int[1001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = s; j <= t; j++) {
                intervals[j] += b;
                max = Math.max(max, intervals[j]);
            }
        }
        out.println(max);

        br.close();
        out.flush();
        out.close();
    }

}