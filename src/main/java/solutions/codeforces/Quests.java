package solutions.codeforces;

import java.io.*;
import java.util.*;

public class Quests {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/problemname.in"));
            out = new PrintWriter(new FileWriter("src/output/problemname.out"));
        } else {
            br = new BufferedReader(new FileReader("problemname.in"));
            out = new PrintWriter(new FileWriter("problemname.out"));
        }

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // # quests
            int k = Integer.parseInt(st.nextToken()); // max quests

            st = new StringTokenizer(br.readLine());
            int[] firstCompletions = new int[n];
            for (int j = 0; j < n; j++) {
                firstCompletions[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] subsequentCompletions = new int[n];
            for (int j = 0; j < n; j++) {
                subsequentCompletions[j] = Integer.parseInt(st.nextToken());
            }

            out.println(solve(k, firstCompletions, subsequentCompletions));
        }

        br.close();
        out.flush();
        out.close();
    }

    public static int solve(int k, int[] firstCompletions, int[] subsequentCompletions) {
        return 0;
    }
}