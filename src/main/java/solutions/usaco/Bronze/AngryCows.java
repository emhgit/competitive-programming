package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class AngryCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(positions);
        int max = 1;
        for (int i = 0; i < N; i++) {
            int l = i, r = i, o = i;
            for (int t = 1; (l > 0); t++) {
                if (positions[o] - positions[l - 1] > t) {
                    break;
                }
                while (l - 1 >= 0 && positions[o] - positions[l - 1] <= t) {
                    l--;
                }
                o = l;
            }
            o = i;
            for (int t = 1; (r < N - 1); t++) {
                if (positions[r + 1] - positions[o] > t) {
                    break;
                }
                while (r + 1 <= N - 1 && positions[r + 1] - positions[o] <= t) {
                    r++;
                }
                o = r;
            }
            max = Math.max(max, r - l + 1);
        }
        out.println(max);
        out.close();
    }
}
