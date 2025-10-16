package solutions.codeforces;

import java.io.*;
import java.util.*;

public class PlayingInACasino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int[][] cards = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    cards[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = 0;
            for (int i = 0; i < m; i++) {
                int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    col[j] = cards[j][i];
                }
                // compute sum of | a_i - a_j | column wise instead of pair wise
                Arrays.sort(col);
                for (int j = 0; j < n; j++) {
                    sum += col[j] * (2 * (j + 1) - n - 1);
                }
            }
            out.println(sum);
        }

        br.close();
        out.flush();
        out.close();
    }
}