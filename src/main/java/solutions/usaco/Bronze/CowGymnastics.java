package solutions.usaco.bronze;

import java.io.*;
import java.util.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        boolean LOCAL = false;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/gymnastics.in"));
            out = new PrintWriter(new FileWriter("src/output/gymnastics.out"));
        } else {
            br = new BufferedReader(new FileReader("gymnastics.in"));
            out = new PrintWriter(new FileWriter("gymnastics.out"));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] better = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int[] rankings = new int[N];
            for (int j = 0; j < N; j++)
                rankings[j] = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    better[rankings[j]][rankings[k]] = true;
                }
            }
        }

        int consistentPairs = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (!better[i][j] || !better[j][i])
                    consistentPairs++;
            }
        }
        out.println(consistentPairs);

        br.close();
        out.flush();
        out.close();
    }
}