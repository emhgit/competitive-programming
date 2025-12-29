package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class DontBeLast {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> namesToIdx = Map.ofEntries(
                Map.entry("Bessie", 0),
                Map.entry("Elsie", 1),
                Map.entry("Daisy", 2),
                Map.entry("Gertie", 3),
                Map.entry("Annabelle", 4),
                Map.entry("Maggie", 5),
                Map.entry("Henrietta", 6));
        Map<Integer, String> idxToNames = Map.ofEntries(
                Map.entry(0, "Bessie"),
                Map.entry(1, "Elsie"),
                Map.entry(2, "Daisy"),
                Map.entry(3, "Gertie"),
                Map.entry(4, "Annabelle"),
                Map.entry(5, "Maggie"),
                Map.entry(6, "Henrietta"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] total = new int[7], sortedTotal = new int[7];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int amt = Integer.parseInt(st.nextToken());
            total[namesToIdx.get(name)] += amt;
            sortedTotal[namesToIdx.get(name)] += amt;
        }
        Arrays.sort(sortedTotal);
        int secondSmallest = sortedTotal[0];
        for (int i = 0; i < 7 && secondSmallest == sortedTotal[0]; i++) {
            secondSmallest = sortedTotal[i];
        }
        String name = "";
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (total[i] == secondSmallest) {
                count++;
                name = idxToNames.get(i);
            }
        }
        if (count > 1) {
            out.println("Tie");
        } else {
            out.println(name);
        }
        out.close();
    }
}
