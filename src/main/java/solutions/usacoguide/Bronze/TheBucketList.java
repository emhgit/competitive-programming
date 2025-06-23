package solutions.usacoguide.Bronze;

import java.io.*;
import java.util.*;

public class TheBucketList {
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

        int[][] cows = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            cows[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = solve(cows);
        out.println(answer);

        br.close();
        out.flush();
        out.close();
    }

    public static int solve(int[][] cows) {
        int buckets = 0;
        for (int i = 0; i < cows.length; i++) {
            int s = cows[i][0];
            int t = cows[i][1];
            int b = cows[i][2];
        }
        return buckets;
    }
}