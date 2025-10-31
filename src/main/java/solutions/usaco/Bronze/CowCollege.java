package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class CowCollege {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] maxTuitions = new long[n];
        for (int i = 0; i < n; i++) {
            maxTuitions[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(maxTuitions);

        long max = Long.MIN_VALUE;
        long tuition = maxTuitions[0];
        for (int i = 0; i < n; i++) {
            long currTuition = maxTuitions[i] * (n - 1 - i + 1);
            if (currTuition > max) {
                max = currTuition;
                tuition = maxTuitions[i];
            }
        }
        out.println(max + " " + tuition);

        br.close();
        out.flush();
        out.close();
    }
}