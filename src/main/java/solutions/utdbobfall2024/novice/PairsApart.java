package solutions.utdbobfall2024.novice;

import java.io.*;
import java.util.*;

public class PairsApart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] maxPairs = new int[k];
        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            scores[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(scores);
        int left = 0, right = n - 1;
        for (int i = 0; i < k; i++) {
            maxPairs[i] = scores[left] + scores[right];
            left++;
            right--;
        }
        for (int sum : maxPairs)
            out.print(sum + " ");
        br.close();
        out.flush();
        out.close();
    }
}
