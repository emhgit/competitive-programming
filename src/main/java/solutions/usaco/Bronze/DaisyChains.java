package solutions.usaco.Bronze;

import java.io.*;
import java.util.*;

public class DaisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] flowers = new int[n];
        for (int i = 0; i < n; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        // iterate over every contiguous substr with two ptrs
        int max = n;
        Set<Integer> visited;
        for (int i = 0; i < n; i++) {
            // use a set to track which elements are in window
            visited = new HashSet<>();
            visited.add(flowers[i]);
            int sum = flowers[i];
            for (int j = i + 1; j < n; j++) {
                visited.add(flowers[j]);
                sum += flowers[j];
                int currLen = j - i + 1;
                if (sum % currLen != 0)
                    continue; // must be integer
                int avg = sum / currLen;
                if (visited.contains(avg))
                    max++; // if the avg is w/i the substr: increment max
            }
        }
        out.println(max);

        br.close();
        out.flush();
        out.close();
    }
}
