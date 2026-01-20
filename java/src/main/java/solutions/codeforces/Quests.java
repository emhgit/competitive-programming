package solutions.codeforces;

import java.io.*;
import java.util.*;

public class Quests {
    // Problem URL: https://codeforces.com/problemset/problem/1914/C
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // # quests
            int k = Integer.parseInt(st.nextToken()); // max quests

            st = new StringTokenizer(br.readLine());
            int[] first = new int[n]; // first completions
            for (int j = 0; j < n; j++) {
                first[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] subs = new int[n]; // subsequent completions
            for (int j = 0; j < n; j++) {
                subs[j] = Integer.parseInt(st.nextToken());
            }
            out.println(solve(k, first, subs));
        }

        br.close();
        out.flush();
        out.close();
    }

    public static int solve(int k, int[] first, int[] subs) {
        int n = Math.min(k, first.length);
        int subsExp = subs[0];
        int totalExp = first[0];
        int maxExp = first[0] + subsExp * (k - 1);
        for (int i = 1; i < n; i++) {
            int currFirst = first[i];
            subsExp = Math.max(subsExp, subs[i]);
            maxExp = Math.max(maxExp, totalExp + currFirst + subsExp * (k - (i + 1)));
            totalExp += currFirst;
        }
        return maxExp;
    }
}