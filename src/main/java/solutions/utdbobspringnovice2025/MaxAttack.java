package solutions.utdbobspringnovice2025;

import java.io.*;
import java.util.*;

public class MaxAttack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] major = new int[2 * n + 1]; // NW -> SE
            int[] minor = new int[2 * n + 2]; // SW -> NE

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                major[x - y + n]++;
                minor[x + y]++;
            }

            int ans = 0;
            for (int j = 1; j <= 2 * n - 1; j++) {
                int d = j - n;
                int len = n - Math.abs(d);
                if (major[j] < len) {
                    ans = Math.max(ans, major[j]);
                }
            }
            for (int j = 2; j <= 2 * n; j++) {
                int len = (j <= n + 1) ? j - 1 : 2 * n + 1 - j;
                if (minor[j] < len) {
                    ans = Math.max(ans, minor[j]);
                }
            }
            out.println(ans);
        }

        br.close();
        out.flush();
        out.close();
    }
}
