package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class ItsMooingTime {
    static int N, F;
    static String contest;
    static Map<String, Integer> freq;
    static Set<String> mooSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        contest = br.readLine();
        freq = new HashMap<>();
        mooSet = new TreeSet<>();
        for (int i = 0; i + 2 < N; i++) {
            if (contest.charAt(i) != contest.charAt(i + 1) && contest.charAt(i + 1) == contest.charAt(i + 2)) {
                String key = i + 2 == N - 1 ? contest.substring(i) : contest.substring(i, i + 3);
                freq.put(key, freq.getOrDefault(key, 0) + 1);
                if (freq.get(key) >= F) {
                    mooSet.add(key);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            upd(i, i + 2, -1, contest.charAt(i), 0);
            upd(i - 1, i + 1, -1, contest.charAt(i), 1);
            upd(i - 2, i, -1, contest.charAt(i), 2);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == contest.charAt(i)) {
                    continue;
                }
                upd(i, i + 2, 1, c, 0);
                upd(i - 1, i + 1, 1, c, 1);
                upd(i - 2, i, 1, c, 2);
                upd(i, i + 2, -1, c, 0);
                upd(i - 1, i + 1, -1, c, 1);
                upd(i - 2, i, -1, c, 2);
            }
            upd(i, i + 2, 1, contest.charAt(i), 0);
            upd(i - 1, i + 1, 1, contest.charAt(i), 1);
            upd(i - 2, i, 1, contest.charAt(i), 2);
        }
        out.println(mooSet.size());
        for (String s : mooSet) {
            out.println(s);
        }
        out.close();
    }

    static void upd(int i, int j, int k, char c, int o) {
        if (i < 0 || j > N - 1) {
            return;
        }
        String s = "";
        switch (o) {
            case 0:
                s = "" + c + contest.charAt(i + 1) + contest.charAt(j);
                break;
            case 1:
                s = "" + contest.charAt(i) + c + contest.charAt(j);
                break;
            case 2:
                s = "" + contest.charAt(i) + "" + contest.charAt(j - 1) + c;
                break;
        }
        if (s.charAt(0) != s.charAt(1) && s.charAt(1) == s.charAt(2)) {
            freq.put(s, freq.getOrDefault(s, 0) + k);
            if (freq.get(s) >= F) {
                mooSet.add(s);
            }
        }
    }
}