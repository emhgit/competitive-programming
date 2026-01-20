package solutions.pshs2026.advanced;

import java.io.*;
import java.util.*;

public class CheckTheLogs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Map<Integer, Integer> visited;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                out.println(-1);
                continue;
            }
            st = new StringTokenizer(br.readLine());
            visited = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int key = Integer.parseInt(st.nextToken());
                visited.put(key, visited.getOrDefault(key, 0) + 1);
            }
            boolean found = false;
            for (Map.Entry<Integer, Integer> e : visited.entrySet()) {
                int key = e.getKey();
                int value = e.getValue();
                if (value % 2 == 1) {
                    found = true;
                    out.println(key);
                    break;
                }
            }
            if (!found) {
                out.println(-1);
            }
        }

    }
}