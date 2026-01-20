package solutions.codeforces;

import java.io.*;
import java.util.*;

public class Kayaking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[2 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weights);
        int min = Integer.MAX_VALUE;
        List<Integer> w;
        for (int i = 0; i < 2 * N; i++) {
            for (int j = i + 1; j < 2 * N; j++) {
                int total = 0;
                w = new ArrayList<>();
                for (int k = 0; k < 2 * N; k++) {
                    if (k != i && k != j) {
                        w.add(weights[k]);
                    }
                }
                for (int k = 0; k < w.size(); k += 2) {
                    total += w.get(k + 1) - w.get(k);
                }
                min = Math.min(min, total);
            }
        }
        out.println(min);
        out.close();
    }
}
