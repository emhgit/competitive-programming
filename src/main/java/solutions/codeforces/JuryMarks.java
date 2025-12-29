package solutions.codeforces;

import java.io.*;
import java.util.*;

public class JuryMarks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[] prefixSums = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(st.nextToken());
            prefixSums[i] += (i == 0) ? a : prefixSums[i - 1] + a;
        }
        Set<Integer> b = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> possibilities = new HashSet<>();
        for (int val : b) {
            for (int i = 0; i < K; i++) {
                possibilities.add(val - prefixSums[i]);
            }
            break;
        }
        int total = 0;
        Set<Integer> visited;
        for (int p : possibilities) {
            visited = new HashSet<>();
            int count = 0;
            for (int i = 0; i < K; i++) {
                if (b.contains(p + prefixSums[i]) && !visited.contains(p + prefixSums[i])) {
                    count++;
                }
                visited.add(p + prefixSums[i]);
            }
            if (count == N) {
                total++;
            }
        }
        out.println(total);
        out.close();
    }
}