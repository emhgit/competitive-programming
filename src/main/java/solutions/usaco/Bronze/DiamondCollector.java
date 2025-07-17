package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/diamond.in"));
            out = new PrintWriter(new FileWriter("src/output/diamond.out"));
        } else {
            br = new BufferedReader(new FileReader("diamond.in"));
            out = new PrintWriter(new FileWriter("diamond.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            diamonds[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(diamonds);

        int max = 1, left = 0;
        for (int right = 1; right < n; right++) {
            while (Math.abs(diamonds[left] - diamonds[right]) > k && left < right) {
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        out.println(max);

        br.close();
        out.flush();
        out.close();
    }
}