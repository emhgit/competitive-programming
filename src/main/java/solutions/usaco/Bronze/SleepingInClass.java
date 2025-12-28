package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class SleepingInClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] periods = new int[N];
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < N; i++) {
                periods[i] = Integer.parseInt(st.nextToken());
                sum += periods[i];
            }
            if (sum == 0) {
                out.println(0);
                continue;
            }
            for (int f = 1; f <= sum; f++) {
                if (sum % f != 0) {
                    continue;
                }
                int curr = 0;
                boolean found = true;
                for (int i = 0; i < N; i++) {
                    curr += periods[i];
                    if (curr > f) {
                        found = false;
                        break;
                    } else if (curr == f) {
                        curr = 0;
                    }
                }
                if (found) {
                    out.println(N - sum / f);
                    break;
                }
            }

        }
        out.close();
    }
}
