package solutions.codeforces;

import java.io.*;
import java.util.*;

public class MaxDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int[] y = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }

        double maxDist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double firstTerm = Math.pow(x[j] - x[i], 2);
                double secondTerm = Math.pow(y[j] - y[i], 2);
                double max = Math.sqrt(firstTerm + secondTerm);
                maxDist = Math.max(maxDist, max);
            }
        }
        out.println(Math.round(Math.pow(maxDist, 2)));

        br.close();
        out.flush();
        out.close();
    }
}