package solutions.atcoder;

import java.io.*;
import java.util.*;

// fails 5 test cases for some reason, but is algorithmically equivalent to the editorial (i think)

public class MadeUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N], b = new int[N];
        Map<Integer, Integer> aFreq = new HashMap<>(), bFreq = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            aFreq.put(a[i], aFreq.getOrDefault(a[i], 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1;
            bFreq.put(b[idx], bFreq.getOrDefault(b[idx], 0) + 1);
        }
        long total = 0;
        for (Map.Entry<Integer, Integer> e : aFreq.entrySet()) {
            int key = e.getKey(), val = e.getValue();
            int bCount = (bFreq.containsKey(key)) ? bFreq.get(key) : 0;
            total += val * bCount;
        }
        out.println(total);
        out.close();
    }
}
