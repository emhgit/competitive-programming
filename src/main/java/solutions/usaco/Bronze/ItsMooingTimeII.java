package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class ItsMooingTimeII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        Map<Long, List<Integer>> oc = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dps = new long[N];
        for (int i = 0; i < N; i++) {
            long key = Long.parseLong(st.nextToken());
            oc.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
            dps[i] = oc.keySet().size();
        }
        long total = 0;
        for (Map.Entry<Long, List<Integer>> e : oc.entrySet()) {
            List<Integer> value = e.getValue();
            if (value.size() < 2) {
                continue;
            }
            int sli = value.size() - 2;
            total += dps[value.get(sli)] - 1;
        }
        out.println(total);
        out.close();
    }
}