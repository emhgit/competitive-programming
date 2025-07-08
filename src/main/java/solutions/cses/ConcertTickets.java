package solutions.cses;

import java.io.*;
import java.util.*;

/*
 * NOTE: custom I/O implementation is needed for this problem,
 * BufferedReader and PrintWriter are too slow. Refer to src/templates/Reader.java
 * for a good I/O implementation. Otherwise, my code implementation for the algorithm
 * is correct.
 */

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map.Entry<Integer, Integer> entry;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> prices = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(st.nextToken());
            prices.put(price, prices.getOrDefault(price, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int maxPrice = Integer.parseInt(st.nextToken());
            entry = prices.floorEntry(maxPrice);
            if (entry == null || entry.getValue() <= 0)
                out.println(-1);
            else {
                int val = entry.getKey();
                out.println(val);
                int newFreq = entry.getValue() - 1;
                if (newFreq <= 0)
                    prices.remove(val);
                else
                    prices.put(val, newFreq);
            }
        }

        br.close();
        out.flush();
        out.close();
    }
}